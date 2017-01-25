package io.continuousfeedback.core

import io.continuousfeedback.core.usecase.ViewOutstandingFeedback.Presenter.OutstandingFeedback

interface FeedbackGateway {
    fun GetOutstandingFeedbackForMember(id: Int) : List<OutstandingFeedback>
}