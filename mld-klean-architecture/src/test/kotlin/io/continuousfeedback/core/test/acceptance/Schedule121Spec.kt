package io.continuousfeedback.core.test.acceptance

import com.winterbe.expekt.should
import io.continuousfeedback.core.boundary.ContinuousFeedback
import io.continuousfeedback.core.test.doubles.InMemoryContinuousFeedback
import io.continuousfeedback.core.usecase.CreateTeamMember
import io.continuousfeedback.core.usecase.Schedule121
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.*

object Schedule121Spec : Spek({
    val continuousFeedback: ContinuousFeedback = InMemoryContinuousFeedback()

    describe("schedule a 121 at a specific time") {
        var successTeamMemberId : Int = 0
        var successDate : String = ""

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
                    Schedule121::class,
                    Schedule121.Request(teamMemberId, date),
                    object : Schedule121.Presenter {
                        override fun onSuccess(teamMemberId : Int, date : String) {
                            successTeamMemberId = teamMemberId
                            successDate = date
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
                it("should be assigned to the team member")  { successTeamMemberId.should.be.equal(1) }
                it("should have a date")  { successDate.should.be.equal(date) }

                it("saves") {
                    continuousFeedback.oneToOneGateway.find(1)!!.date.should.be.equal(date)
                }
            }
        }
    }
})

