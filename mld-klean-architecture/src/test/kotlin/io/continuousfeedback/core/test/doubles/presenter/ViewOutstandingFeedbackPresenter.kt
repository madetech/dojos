package io.continuousfeedback.core.test.doubles.presenter

import io.continuousfeedback.core.usecase.ViewOutstandingFeedback.Presenter

class ViewOutstandingFeedbackPresenter(val onSuccess: (List<Presenter.OutstandingFeedback>) -> Unit) : Presenter {
    override fun presentFeedback(feedback: List<Presenter.OutstandingFeedback>) = onSuccess(feedback)

}