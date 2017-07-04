class Lcd
  NUMBER_HASH = {
    '0' => " -- \n|  |\n|  |\n    \n|  |\n|  |\n -- ",
    '1' => "    \n   |\n   |\n    \n   |\n   |\n    ",
    '2' => " -- \n   |\n   |\n -- \n|   \n|   \n -- ",
    '3' => " -- \n   |\n   |\n -- \n   |\n   |\n -- ",
    '4' => "    \n|  |\n|  |\n -- \n   |\n   |\n    ",
    '5' => " -- \n|   \n|   \n -- \n   |\n   |\n -- ",
    '6' => " -- \n   |\n   |\n -- \n|  |\n|  |\n -- ",
    '7' => " -- \n   |\n   |\n    \n   |\n   |\n    ",
    '8' => " -- \n|  |\n|  |\n -- \n|  |\n|  |\n -- ",
    '9' => " -- \n|  |\n|  |\n -- \n   |\n   |\n    "
  }
  def display(number)
    display_array = ['', '', '', '', '', '', '']

    number.chars.each_with_index do |num, index|
      if index > 0
        display_array.each do |line|
          line << ' '
        end
      end
      number_string = NUMBER_HASH[num]
      number_array = number_string.split("\n")
      number_array.each_with_index do |n, idx|
        display_array[idx] << n
      end
    end
    display_array.join("\n")
  end
end
