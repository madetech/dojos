package io.continuousfeedback.core

import io.continuousfeedback.core.usecase.ScheduleOne2One

class ScheduleOne2One(val one2OneGateway: One2OneGateway) : ScheduleOne2One {
    override fun execute(request: io.continuousfeedback.core.usecase.ScheduleOne2One.Request, presenter: io.continuousfeedback.core.usecase.ScheduleOne2One.Presenter) {
        val oneToOne = ScheduleOne2One.Presenter.OneToOne(teamMemberId = request.teamMemberId, date = request.date)
        presenter.onSuccess(oneToOne)
    }
}
