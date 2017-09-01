defmodule Tennis do
  @moduledoc "Tennis scoring engine"

  def start_game(player_1, player_2) do
    %{player_1 => 0, player_2 => 0}
  end

  def score(game) do
    IO.write "Fifteen-Love"
  end

  def won_point(game, player) do
    if game_complete?(game) do
      game
    else
      if double_deuce?(game, player) do
        reset_advantage(game)
      else
        if deuce?(game) do
          %{game | player => :advantage}
        else
          Map.update(game, player, 15, &(increment_points(&1)))
        end
      end
    end
  end

  defp increment_points(30),          do: 40
  defp increment_points(40),          do: 50
  defp increment_points(:advantage),  do: 50
  defp increment_points(points), do: points + 15

  defp deuce?(game) do
    Enum.all?(Map.values(game), &(&1 == 40))
  end

  defp double_deuce?(game, player) do
    Map.fetch!(game, player) == 40 &&
      Enum.sort(Map.values(game)) == [40, :advantage]
  end

  defp game_complete?(game) do
    Enum.any?(Map.values(game), &(&1 == 50))
  end

  defp reset_advantage(game) do
    for {k, _} <- game, into: %{}, do: {k, 40}
  end
end
