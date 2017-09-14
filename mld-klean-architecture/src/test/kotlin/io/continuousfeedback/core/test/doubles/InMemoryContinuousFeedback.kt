package io.continuousfeedback.core.test.doubles

import io.continuousfeedback.core.TeamGateway
import io.continuousfeedback.core.One2OneGateway
import io.continuousfeedback.core.boundary.ContinuousFeedback
import io.continuousfeedback.core.test.doubles.gateway.InMemoryTeamRepository
import io.continuousfeedback.core.test.doubles.gateway.InMemoryOne2OneRepository


class InMemoryContinuousFeedback : ContinuousFeedback() {
    override val teamGateway: TeamGateway = InMemoryTeamRepository()
    override val one2OneGateway: One2OneGateway = InMemoryOne2OneRepository()
}