package io.continuousfeedback.core.test.acceptance

import com.winterbe.expekt.should
import io.continuousfeedback.core.boundary.ContinuousFeedback
import io.continuousfeedback.core.test.doubles.InMemoryContinuousFeedback
import io.continuousfeedback.core.test.doubles.presenter.ViewOutstandingFeedbackPresenter
import io.continuousfeedback.core.usecase.CreateTeamMember
import io.continuousfeedback.core.usecase.ViewOutstandingFeedback
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.context
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it


object ViewOutstandingFeedbackSpec : Spek({
    val continuousFeedback: ContinuousFeedback = InMemoryContinuousFeedback()

    describe("Viewing outstanding feedback for a team member") {
        var feedback: List<ViewOutstandingFeedback.Presenter.OutstandingFeedback> = listOf()

        fun executeViewOutstandingFeedback(id: Int) {
            val presenter = ViewOutstandingFeedbackPresenter(
                    onSuccess = { feedback = it }
            )
            continuousFeedback.executeUseCase(
                    ViewOutstandingFeedback::class,
                    ViewOutstandingFeedback.Request(id),
                    presenter
            )
        }

        fun executeCreateTeamMember(email: String) {
            continuousFeedback.executeUseCase(
                    CreateTeamMember::class,
                    CreateTeamMember.Request(email),
                    object : CreateTeamMember.Presenter {
                        override fun onSuccess() {
                        }
                    }
            )
        }

        given("A team member") {
            beforeGroup {
                executeCreateTeamMember("abc@madetech.com")
            }

            context("Team member has no feedback") {
                beforeGroup {
                    executeViewOutstandingFeedback(id=1)
                }
                it("should have no feedback") {
                    feedback.size.should.equal(0)
                }
            }
        }

    }
})