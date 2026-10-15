package TicTacToe.Strategy.BotStrategy;

import TicTacToe.model.Board;
import TicTacToe.model.Move;
import TicTacToe.model.Player;

public interface BotPlayingStrategy {
    Move takeMove(Board board, Player player);
}
