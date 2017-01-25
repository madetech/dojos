package io.continuousfeedback.core

import io.continuousfeedback.core.domain.OneToOne
import io.continuousfeedback.core.usecase.Schedule121

class Schedule121(val teamGateway: TeamGateway, val oneToOneGateway: OneToOneGateway) : Schedule121 {
    override fun execute(request: Schedule121.Request, presenter: Schedule121.Presenter) {
        oneToOneGateway.save(OneToOne(null, request.teamMemberId, request.date))
        presenter.onSuccess(request.teamMemberId, request.date)
    }
}
