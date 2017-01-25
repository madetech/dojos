package io.continuousfeedback.core.boundary

import com.madetech.clean.boundary.CleanApplication
import com.madetech.clean.usecase.AsynchronousUseCase
import io.continuousfeedback.core.OneToOneGateway
import io.continuousfeedback.core.TeamGateway
import io.continuousfeedback.core.FeedbackGateway
import io.continuousfeedback.core.usecase.*
import kotlin.reflect.KClass

abstract class ContinuousFeedback : CleanApplication() {
    abstract val teamGateway: TeamGateway
    abstract val oneToOneGateway: OneToOneGateway
    abstract val feedbackGateway: FeedbackGateway

    override fun unsafeConstruct(useCase: KClass<*>): AsynchronousUseCase<*, *>? {
        return when (useCase) {
            RequestFeedback::class -> io.continuousfeedback.core.RequestFeedback(teamGateway)
            CreateTeamMember::class -> io.continuousfeedback.core.CreateTeamMember(teamGateway)
            ViewNextOneToOne::class -> io.continuousfeedback.core.ViewNextOneToOne(oneToOneGateway)
            ViewCompletedOneToOnes::class -> io.continuousfeedback.core.ViewCompletedOneToOnes(oneToOneGateway)
            ViewOutstandingFeedback::class -> io.continuousfeedback.core.ViewOutstandingFeedback(feedbackGateway)
            else -> null
        }
    }
}