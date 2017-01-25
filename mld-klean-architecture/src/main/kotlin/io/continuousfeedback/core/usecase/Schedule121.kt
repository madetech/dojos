package io.continuousfeedback.core.usecase

import com.madetech.clean.usecase.AsynchronousUseCase
import io.continuousfeedback.core.usecase.Schedule121.Presenter
import io.continuousfeedback.core.usecase.Schedule121.Request

interface Schedule121 : AsynchronousUseCase<Request, Presenter> {
    data class Request(val teamMemberId: Int, val date: String)

    interface Presenter {
        data class OneToOne(val teamMemberId: Int, val date: String)

        fun onSuccess(teamMemberId: Int, date: String)
    }
}