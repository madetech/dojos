defmodule TennisTest do
@moduledoc """
  Tennis tests innit
"""
  use ExUnit.Case

  import ExUnit.CaptureIO

  doctest Tennis

  describe "starting the game" do
    test "when given player names it returns the name and initial score" do
      game = Tennis.start_game('foo', 'bar')
      assert game == %{'foo' => 0, 'bar' => 0}
    end

    test "when given other player names it returns the names and inital scores" do
      game = Tennis.start_game('foobar', 'barfoo')
      assert game == %{'foobar' => 0, 'barfoo' => 0}
    end
  end

  describe "scoring during the game" do
    setup do
      %{game: game()}
    end

    test "given player 1 scores a point", %{game: game} do
      score = Tennis.won_point(game, 'Andy')

      assert score == %{'Andy' => 15, 'Roger' => 0}
    end

    test "given player 2 scores a point", %{game: game} do
      score = Tennis.won_point(game, 'Roger')

      assert score == %{'Andy' => 0, 'Roger' => 15}
    end

    test "given player 2 scores a point after player one already has", %{game: game} do
      score = game |> Tennis.won_point('Andy') |> Tennis.won_point('Roger')

      assert score == %{'Andy' => 15, 'Roger' => 15}
    end

    test "given player 1 scores twice", %{game: game} do
      score = game |> Tennis.won_point('Andy') |> Tennis.won_point('Andy')

      assert score == %{'Andy' => 30, 'Roger' => 0}
    end

    test "given player 1 scores thrice", %{game: game} do
      score = game |> Tennis.won_point('Andy') |> Tennis.won_point('Andy') |> Tennis.won_point('Andy')

      assert score == %{'Andy' => 40, 'Roger' => 0}
    end

    test "given player 1 wins m-m-m-multi-kills", %{game: game} do
      score = game
              |> Tennis.won_point('Andy')
              |> Tennis.won_point('Andy')
              |> Tennis.won_point('Andy')
              |> Tennis.won_point('Andy')

      assert score == %{'Andy' => 50, 'Roger' => 0}
    end

    test "given player 1 has already won but is a poor winner", %{game: game} do
      score = game
              |> Tennis.won_point('Andy')
              |> Tennis.won_point('Andy')
              |> Tennis.won_point('Andy')
              |> Tennis.won_point('Andy')
              |> Tennis.won_point('Andy')

      assert score == %{'Andy' => 50, 'Roger' => 0}
    end

    test "given player 1 has already won but player 2 is in denial", %{game: game} do
      score = game
              |> Tennis.won_point('Andy')
              |> Tennis.won_point('Andy')
              |> Tennis.won_point('Andy')
              |> Tennis.won_point('Andy')
              |> Tennis.won_point('Roger')

      assert score == %{'Andy' => 50, 'Roger' => 0}
    end

    test "given player 1 and player 2 are evenly matched", %{game: game} do
      score = game
              |> Tennis.won_point('Andy')
              |> Tennis.won_point('Roger')
              |> Tennis.won_point('Andy')
              |> Tennis.won_point('Roger')
              |> Tennis.won_point('Andy')
              |> Tennis.won_point('Roger')
              |> Tennis.won_point('Andy')

      assert score == %{'Andy' => :advantage, 'Roger' => 40}
    end

    test "given player 1 and player 2 want to delay all the other broadcasts", %{game: game} do
      score = game
              |> Tennis.won_point('Andy')
              |> Tennis.won_point('Roger')
              |> Tennis.won_point('Andy')
              |> Tennis.won_point('Roger')
              |> Tennis.won_point('Andy')
              |> Tennis.won_point('Roger')
              |> Tennis.won_point('Andy')
              |> Tennis.won_point('Roger')

      assert score == %{'Andy' => 40, 'Roger' => 40}
    end

    test "given player 1 and player 2 can't stop scoring points", %{game: game} do
      score = game
              |> Tennis.won_point('Roger')
              |> Tennis.won_point('Andy')
              |> Tennis.won_point('Roger')
              |> Tennis.won_point('Andy')
              |> Tennis.won_point('Roger')
              |> Tennis.won_point('Andy')
              |> Tennis.won_point('Roger')
              |> Tennis.won_point('Andy')

      assert score == %{'Andy' => 40, 'Roger' => 40}
    end

    test "given player 1 breaks player 2", %{game: game} do
      score = game
              |> Tennis.won_point('Andy')
              |> Tennis.won_point('Roger')
              |> Tennis.won_point('Andy')
              |> Tennis.won_point('Roger')
              |> Tennis.won_point('Andy')
              |> Tennis.won_point('Roger')
              |> Tennis.won_point('Andy')
              |> Tennis.won_point('Andy')
        assert score == %{'Andy' => 50, 'Roger' => 40}
    end
  end

  describe "Announcing the score" do
    setup do
      %{game: game()}
    end

    defp assert_announcement(game, announcement) do
      assert capture_io(fn -> Tennis.score(game) end) == announcement
    end

    test "given player 1 has scored", %{game: game} do
      score = Tennis.won_point(game, 'Andy')
      assert_announcement(score, "Fifteen-Love")
    end
  end

  defp game do
    Tennis.start_game('Andy', 'Roger')
  end
end
