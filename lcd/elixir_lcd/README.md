# ElixirLcd

## Task

Based on [Ruby Quiz #14](http://rubyquiz.com/quiz14.html), create a program that can convert integers to LCD style numbers and output them in the console e.g.

```
   --   --
|    |    |
|    |    |
   --   --
| |       |
| |       |
   --   --
```

The program should also allow a user to change the size of the LCD numbers, via an `-s` option. This affects how many vertical and horizontal lines are used to construct each section of a given number, with the default being `2`.

## Format

- 5 mins: brief & pastries
- 45 mins: split into teams of 2 or 3 and try to solve the kata within 45 minutes
- 10 mins: regroup and each team discusses their approach

## Installation

If [available in Hex](https://hex.pm/docs/publish), the package can be installed
by adding `elixir_lcd` to your list of dependencies in `mix.exs`:

```elixir
def deps do
  [{:elixir_lcd, "~> 0.1.0"}]
end
```

Documentation can be generated with [ExDoc](https://github.com/elixir-lang/ex_doc)
and published on [HexDocs](https://hexdocs.pm). Once published, the docs can
be found at [https://hexdocs.pm/elixir_lcd](https://hexdocs.pm/elixir_lcd).

