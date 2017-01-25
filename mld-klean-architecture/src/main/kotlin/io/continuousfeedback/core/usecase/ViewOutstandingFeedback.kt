package io.continuousfeedback.core.usecase;

import com.madetech.clean.usecase.AsynchronousUseCase
import io.continuousfeedback.core.usecase.ViewOutstandingFeedback.Request
import io.continuousfeedback.core.usecase.ViewOutstandingFeedback.Presenter

interface ViewOutstandingFeedback : AsynchronousUseCase<Request, Presenter> {
    data class Request(val teamMemberId: Int)
    interface Presenter {
        fun presentFeedback(feedback: List<OutstandingFeedback>)
        data class OutstandingFeedback(val comment: String)
    }
}
