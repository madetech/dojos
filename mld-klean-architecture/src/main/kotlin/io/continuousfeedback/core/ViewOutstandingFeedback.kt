package io.continuousfeedback.core

import io.continuousfeedback.core.usecase.ViewOutstandingFeedback

class ViewOutstandingFeedback(val feedbackGateway: FeedbackGateway) : ViewOutstandingFeedback {

    override fun execute(request: ViewOutstandingFeedback.Request, presenter: ViewOutstandingFeedback.Presenter) {
        presenter.presentFeedback(feedbackGateway.GetOutstandingFeedbackForMember(request.teamMemberId))
    }
}