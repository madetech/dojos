require_relative 'lib/lcd_generator'


STDOUT.write LCDGenerator.to_lcd(ARGV.first)
