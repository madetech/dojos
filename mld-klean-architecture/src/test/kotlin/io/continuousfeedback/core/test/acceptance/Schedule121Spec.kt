package io.continuousfeedback.core.test.acceptance

import com.winterbe.expekt.should
import io.continuousfeedback.core.boundary.ContinuousFeedback
import io.continuousfeedback.core.test.doubles.InMemoryContinuousFeedback
import io.continuousfeedback.core.usecase.CreateTeamMember
import io.continuousfeedback.core.usecase.ScheduleOne2One
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.*

object Schedule121Spec : Spek({
    val continuousFeedback: ContinuousFeedback = InMemoryContinuousFeedback()

    describe("schedule a 121 at a specific time") {
        var scheduleOneToOneData: ScheduleOne2One.Presenter.OneToOne = ScheduleOne2One.Presenter.OneToOne(1, "ABC")

        fun executeCreateTeamMember(email: String) {
            continuousFeedback.executeUseCase(
                    CreateTeamMember::class,
                    CreateTeamMember.Request(email),
                    object : CreateTeamMember.Presenter {
                        override fun onSuccess() {}
                    }
            )
        }

        fun executeSchedule121(teamMemberId: Int, date: String) {
            continuousFeedback.executeUseCase(
                    ScheduleOne2One::class,
                    ScheduleOne2One.Request(teamMemberId, date),
                    object : ScheduleOne2One.Presenter {
                        override fun onSuccess(data: ScheduleOne2One.Presenter.OneToOne) {
                            scheduleOneToOneData = data
                        }
                    }
            )
        }

        given("a team member exists") {
            val teamMemberEmail = "david@madetech.com"
            executeCreateTeamMember(teamMemberEmail)

            context("when you schedule a 121") {
                val date = "2017-01-31"
                beforeGroup { executeSchedule121(1, date) }
                it("will be displayed") {
                    scheduleOneToOneData.teamMemberId.should.equal(1)
                    scheduleOneToOneData.date.should.equal(date)
                }
            }
        }
    }
})

