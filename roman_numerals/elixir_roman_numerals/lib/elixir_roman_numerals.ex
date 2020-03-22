defmodule ElixirRomanNumerals do
  @moduledoc """
  Documentation for ElixirRomanNumerals.
  """

  @doc """
  Converts integers to roman numerals.

  ## Examples

      iex> ElixirRomanNumerals.to_roman(1)
      "I"

      iex> ElixirRomanNumerals.to_roman(3)
      "III"

      iex> ElixirRomanNumerals.to_roman(5)
      "V"

      iex> ElixirRomanNumerals.to_roman(6)
      "VI"

      iex> ElixirRomanNumerals.to_roman(4)
      "IV"

      iex> ElixirRomanNumerals.to_roman(9)
      "IX"

      iex> ElixirRomanNumerals.to_roman(10)
      "X"

      iex> ElixirRomanNumerals.to_roman(20)
      "XX"

      iex> ElixirRomanNumerals.to_roman(24)
      "XXIV"

      iex> ElixirRomanNumerals.to_roman(19)
      "XIX"

      iex> ElixirRomanNumerals.to_roman(50)
      "L"

      iex> ElixirRomanNumerals.to_roman(40)
      "XL"

      iex> ElixirRomanNumerals.to_roman(59)
      "LIX"

      iex> ElixirRomanNumerals.to_roman(70)
      "LXX"

      iex> ElixirRomanNumerals.to_roman(90)
      "XC"

      iex> ElixirRomanNumerals.to_roman(100)
      "C"

      iex> ElixirRomanNumerals.to_roman(98)
      "XCVIII"

      iex> ElixirRomanNumerals.to_roman(99)
      "IC"

      iex> ElixirRomanNumerals.to_roman(500)
      "D"

      iex> ElixirRomanNumerals.to_roman(400)
      "CD"

      iex> ElixirRomanNumerals.to_roman(1000)
      "M"

      iex> ElixirRomanNumerals.to_roman(900)
      "CM"

      iex> ElixirRomanNumerals.to_roman(999)
      "IM"

  """
  def to_roman(i) do
    String.duplicate("I", i)
    |> String.replace("IIIII", "V")
    |> String.replace("VV", "X")
    |> String.replace("XXXXX", "L")
    |> String.replace("LL", "C")
    |> String.replace("CCCCC", "D")
    |> String.replace("DD", "M")

    |> String.replace("CCCC", "CD")
    |> String.replace("XXXX", "XL")
    |> String.replace("IIII", "IV")

    |> String.replace("VIV", "IX")
    |> String.replace("LXL", "XC")
    |> String.replace("XCIX", "IC")
    |> String.replace("DCD", "CM")
    |> String.replace("CMIC", "IM")
  end
end
