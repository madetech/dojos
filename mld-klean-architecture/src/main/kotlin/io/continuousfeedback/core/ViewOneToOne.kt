package io.continuousfeedback.core

import io.continuousfeedback.core.domain.OneToOne
import io.continuousfeedback.core.usecase.ViewOneToOne

class ViewOneToOne(val oneToOneGateway: OneToOneGateway) : ViewOneToOne {
    override fun execute(request: ViewOneToOne.Request, presenter: ViewOneToOne.Presenter) {
        val response : List<OneToOne> = oneToOneGateway.getAll().filter { it.teamMemberId == request.teamMemberId }
        val oneToOne = response.first()
        presenter.onSuccess(oneToOne.date)
    }
}
