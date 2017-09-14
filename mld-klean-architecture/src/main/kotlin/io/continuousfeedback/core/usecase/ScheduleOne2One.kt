package io.continuousfeedback.core.usecase

import com.madetech.clean.usecase.AsynchronousUseCase
import io.continuousfeedback.core.usecase.ScheduleOne2One.Presenter
import io.continuousfeedback.core.usecase.ScheduleOne2One.Request
import java.util.*

interface ScheduleOne2One : AsynchronousUseCase<Request, Presenter> {
    data class Request(val teamMemberId: Int, val date: String)

    interface Presenter {
        data class OneToOne(val teamMemberId: Int, val date: String)

        fun onSuccess(data:OneToOne)
    }
}

