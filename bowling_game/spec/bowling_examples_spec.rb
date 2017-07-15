require_relative "../lib/bowling"

RSpec.describe Bowling do
  let(:game) { Bowling.new }

  describe "When playing bowling" do
      context "calculating a spare" do
        it "correctly calculates the score when rolling a spare" do
          game.roll(5)
          game.roll(5)
          game.roll(5)
          game.roll(4)
          expect(game.score).to eq(20)
        end
      end

      context "calculating a strike" do
        context "if you get a strike" do
          it "totals the score correctly" do
            game.roll(10)
            game.roll(5)
            game.roll(4)

            expect(game.score).to eq(28)
          end

          it "you get two strikes in a row and then a non stike frame" do
            game.roll(10)
            game.roll(10)
            game.roll(5)
            game.roll(4)

            expect(game.score).to eq(53)
          end
        end
      end
  	end
  end 
end
