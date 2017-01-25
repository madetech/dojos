package io.continuousfeedback.core.test.doubles.gateway

import io.continuousfeedback.core.FeedbackGateway
import io.continuousfeedback.core.usecase.ViewOutstandingFeedback

class InMemoryFeedbackGateway : FeedbackGateway {
    var feedback: MutableList<ViewOutstandingFeedback.Presenter.OutstandingFeedback> = mutableListOf()

    fun addFeedback(comment: String) {
        feedback.add(ViewOutstandingFeedback.Presenter.OutstandingFeedback(comment = comment))
    }

    fun clearFeedback() {
        feedback.clear()
    }

    override fun GetOutstandingFeedbackForMember(id: Int): List<ViewOutstandingFeedback.Presenter.OutstandingFeedback> {
        return feedback.toList()
    }

}