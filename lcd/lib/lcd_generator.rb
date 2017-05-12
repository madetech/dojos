class LCDGenerator
	def self.segments(integer)
		case(integer)
		when 0
			[true,true,true,false,true,true,true]
		when 1
			[false,false,true,false,false,true,false]
		when 2
			[true,false,true,true,true,false,true]
		when 3
			[true,false,true,true,false,true,true]
		when 4
			[false,true,true,true,false,true,false]
		when 5
			[true,true,false,true,false,true,true]
		when 6
			[true,true,false,true,true,true,true]
		when 7
			[true,false,true,false,false,true,false]
		when 8
			[true,true,true,true,true,true,true]
		when 9
			[true,true,true,true,false,true,true]
		end
	end

	def self.segment(state, character)
		if state
			character
		else
			' '
		end
	end	

	def self.convert(integer)
		s = segments(integer)

		" #{segment(s[0],'-')} \n" + 
		"#{segment(s[1], '|')} #{segment(s[2], '|')}\n" +
		" #{segment(s[3],'-')} \n" +
		"#{segment(s[4], '|')} #{segment(s[5], '|')}\n" +
		" #{segment(s[6],'-')} "
	end

	def self.to_lcd(string)
		lines = [
			"",
			"",
			"",
			"",
			""
		]
		string.split('').each do |character|

			s = segments(character.to_i)

			lines[0] << " #{segment(s[0],'-')}  "
			lines[1] << "#{segment(s[1], '|')} #{segment(s[2], '|')} "
			lines[2] << " #{segment(s[3],'-')}  "
			lines[3] << "#{segment(s[4], '|')} #{segment(s[5], '|')} "
			lines[4] << " #{segment(s[6],'-')}  "
		end

		output = ""
		lines.each do |line|
			output << "#{line.chomp(' ')}\n"
		end
		output.chomp("\n")
	end

end
