package io.continuousfeedback.core

import io.continuousfeedback.core.usecase.Schedule121

class Schedule121(val teamGateway: TeamGateway) : Schedule121 {
    override fun execute(request: Schedule121.Request, presenter: Schedule121.Presenter) {

        val oneToOne = Schedule121.Presenter.OneToOne(teamMemberId = request.teamMemberId, date = request.date)
        presenter.onSuccess()
    }
}
