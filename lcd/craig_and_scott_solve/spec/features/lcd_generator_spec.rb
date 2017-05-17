require_relative '../../lib/lcd_generator'

describe 'LCD generator' do
	it 'converts the number 8 to LCD format' do
		expectation = " - \n" + 
									"| |\n" +
									" - \n" +
									"| |\n" +
									" - "
		expect(LCDGenerator.to_lcd("8")).to eq(expectation)
	end

	it 'converts the number 1 to LCD format' do
		expectation = "   \n" + 
									"  |\n" +
									"   \n" +
									"  |\n" +
									"   "
		expect(LCDGenerator.to_lcd("1")).to eq(expectation)
	end

	it 'converts the number 10 to LCD format' do
		expectation = "     - \n" + 
									"  | | |\n" +
									"       \n" +
									"  | | |\n" +
									"     - "
		expect(LCDGenerator.to_lcd("10")).to eq(expectation)
	end

	it 'has all segments on for the number 0' do
		expect(LCDGenerator.segments(0)).to eq([true,true,true,false,true,true,true])
	end

	it 'has all segments on for the number 1' do
		expect(LCDGenerator.segments(1)).to eq([false,false,true,false,false,true,false])
	end

	it 'has all segments on for the number 2' do
		expect(LCDGenerator.segments(2)).to eq([true,false,true,true,true,false,true])
	end

	it 'has all segments on for the number 3' do
		expect(LCDGenerator.segments(3)).to eq([true,false,true,true,false,true,true])
	end

	it 'has all segments on for the number 4' do
		expect(LCDGenerator.segments(4)).to eq([false,true,true,true,false,true,false])
	end

	it 'has all segments on for the number 5' do
		expect(LCDGenerator.segments(5)).to eq([true,true,false,true,false,true,true])
	end

	it 'has all segments on for the number 6' do
		expect(LCDGenerator.segments(6)).to eq([true,true,false,true,true,true,true])
	end

	it 'has all segments on for the number 7' do
		expect(LCDGenerator.segments(7)).to eq([true,false,true,false,false,true,false])
	end

	it 'has all segments on for the number 8' do
		expect(LCDGenerator.segments(8)).to eq([true,true,true,true,true,true,true])
	end

	it 'has all segments on for the number 9' do
		expect(LCDGenerator.segments(9)).to eq([true,true,true,true,false,true,true])
	end
end
