package io.continuousfeedback.core.usecase

import com.madetech.clean.usecase.AsynchronousUseCase
import io.continuousfeedback.core.usecase.ViewOneToOne.Presenter
import io.continuousfeedback.core.usecase.ViewOneToOne.Request

interface ViewOneToOne : AsynchronousUseCase<Request, Presenter> {
    data class Request(val teamMemberId: Int)

    interface Presenter {
        fun onSuccess(date: String)
    }
}