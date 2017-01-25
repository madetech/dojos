package io.continuousfeedback.core.test.unit

import io.continuousfeedback.core.ScheduleOne2One
import io.continuousfeedback.core.test.doubles.gateway.InMemoryOne2OneRepository
import org.jetbrains.spek.subject.SubjectSpek
import io.continuousfeedback.core.One2OneGateway
import org.jetbrains.spek.api.dsl.given

class ScheduleOne2OneSpec: SubjectSpek<ScheduleOne2One>({
    val one2OneGateway: One2OneGateway = InMemoryOne2OneRepository()
    subject { ScheduleOne2One(one2OneGateway) }

    given("a scheduled date exists in the future") {

    }
})