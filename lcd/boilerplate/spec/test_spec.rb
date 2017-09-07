require_relative '../lib/lcd'
require 'pry'

describe Lcd  do
  describe '#display' do
    let(:lcd) { described_class.new }

    context 'single digits' do
      it "should display the number 0 in LCD format" do
        expect(lcd.display('0')).to eq(" -- \n|  |\n|  |\n    \n|  |\n|  |\n -- ")
      end

      it 'should display the number 1 in LCD format' do
        expect(lcd.display('1')).to eq("    \n   |\n   |\n    \n   |\n   |\n    ")
      end

      it 'should display the number 2 in LCD format' do
        expect(lcd.display('2')).to eq(" -- \n   |\n   |\n -- \n|   \n|   \n -- ")
      end

      it "should display the number 3 in LCD format" do
        expect(lcd.display('3')).to eq(" -- \n   |\n   |\n -- \n   |\n   |\n -- ")
      end

      it "should display the number 4 in LCD format" do
        expect(lcd.display('4')).to eq("    \n|  |\n|  |\n -- \n   |\n   |\n    ")
      end

      it "should display the number 5 in LCD format" do
        expect(lcd.display('5')).to eq(" -- \n|   \n|   \n -- \n   |\n   |\n -- ")
      end

      it "should display the number 6 in LCD format" do
        expect(lcd.display('6')).to eq(" -- \n   |\n   |\n -- \n|  |\n|  |\n -- ")
      end

      it "should display the number 7 in the LCD format" do
        expect(lcd.display('7')).to eq(" -- \n   |\n   |\n    \n   |\n   |\n    ")
      end

      it "should display the number 8 in the LCD format" do
        expect(lcd.display('8')).to eq(" -- \n|  |\n|  |\n -- \n|  |\n|  |\n -- ")
      end

      it "should display the number 9 in the LCD format" do
        expect(lcd.display('9')).to eq(" -- \n|  |\n|  |\n -- \n   |\n   |\n    ")
      end
    end

    context 'multiple digits' do
      it "should display the number 11 in LCD format" do
        expect(lcd.display('11')).to eq("         \n   |    |\n   |    |\n         \n   |    |\n   |    |\n         ")
      end

      it "should display the number 701" do
        expect(lcd.display('701')).to eq(" --   --      \n   | |  |    |\n   | |  |    |\n              \n   | |  |    |\n   | |  |    |\n      --      ")
      end
    end
  end
end
