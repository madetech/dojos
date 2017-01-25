package io.continuousfeedback.core.boundary

import com.madetech.clean.boundary.CleanApplication
import com.madetech.clean.usecase.AsynchronousUseCase
import io.continuousfeedback.core.usecase.ScheduleOne2One
import io.continuousfeedback.core.TeamGateway
import io.continuousfeedback.core.One2OneGateway
import io.continuousfeedback.core.usecase.CreateTeamMember
import io.continuousfeedback.core.usecase.RequestFeedback
import kotlin.reflect.KClass

abstract class ContinuousFeedback : CleanApplication() {
    abstract val teamGateway: TeamGateway
    abstract val one2OneGateway: One2OneGateway

    override fun unsafeConstruct(useCase: KClass<*>): AsynchronousUseCase<*, *>? {
        return when (useCase) {
            RequestFeedback::class -> io.continuousfeedback.core.RequestFeedback(teamGateway)
            CreateTeamMember::class -> io.continuousfeedback.core.CreateTeamMember(teamGateway)
            ScheduleOne2One::class -> io.continuousfeedback.core.ScheduleOne2One(one2OneGateway)
            else -> null
        }
    }
}