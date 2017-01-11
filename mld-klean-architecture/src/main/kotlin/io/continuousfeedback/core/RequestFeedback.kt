package io.continuousfeedback.core

import io.continuousfeedback.core.domain.TeamMember
import io.continuousfeedback.core.usecase.RequestFeedback
import io.continuousfeedback.core.usecase.RequestFeedback.*
import io.continuousfeedback.core.usecase.RequestFeedback.Error.RECEIVER_NOT_FOUND

class RequestFeedback(val teamGateway: TeamGateway) : RequestFeedback {
    override fun execute(request: Request, presenter: Presenter) {
        val id = request.receiverId

        if (teamGateway.find(teamMemberId = id) == null) {
            presenter.presentError(RECEIVER_NOT_FOUND)
            return
        }

        teamGateway.getAllExceptFeedbackReceiver(receiverId = id)
                .sendNotificationsForAlLTo(presenter)
    }

    fun List<TeamMember>.sendNotificationsForAlLTo(presenter: Presenter) = this.forEach { presenter.notify(it.email) }

    fun TeamGateway.getAllExceptFeedbackReceiver(receiverId: Int) = this.getAll().filter { it.id != receiverId }

    fun Presenter.notify(email: String) = this.presentNotification(Notification(email = email))
}
