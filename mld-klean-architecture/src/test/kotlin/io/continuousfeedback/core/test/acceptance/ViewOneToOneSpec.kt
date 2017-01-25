package io.continuousfeedback.core.test.acceptance

import com.winterbe.expekt.should
import io.continuousfeedback.core.boundary.ContinuousFeedback
import io.continuousfeedback.core.test.doubles.InMemoryContinuousFeedback
import io.continuousfeedback.core.usecase.CreateTeamMember
import io.continuousfeedback.core.usecase.Schedule121
import io.continuousfeedback.core.usecase.ViewOneToOne
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.*

object ViewOneToOneSpec : Spek({
    val continuousFeedback: ContinuousFeedback = InMemoryContinuousFeedback()
    var successDate: String = ""

    describe("retrieve one to one for specified user") {
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
                        override fun onSuccess(teamMemberId : Int, date : String) {}
                    }
            )
        }

        fun executeViewOneToOne(teamMemberId: Int) {
            continuousFeedback.executeUseCase(
                    ViewOneToOne::class,
                    ViewOneToOne.Request(teamMemberId),
                    object : ViewOneToOne.Presenter {
                        override fun onSuccess(date : String) {
                            successDate = date
                        }
                    }
            )
        }

        given("a one to one exists") {
            val teamMemberEmail = "david@madetech.com"
            val oneToOneDate = "01/01/2017"
            executeCreateTeamMember(teamMemberEmail)
            executeSchedule121(1, oneToOneDate)

            context("when I retreive my latest 121") {
                beforeGroup { executeViewOneToOne(1) }

                it("show me my one to one") {
                    successDate.should.be.equal(oneToOneDate)
                }
            }
        }
    }
})

