package TicTacToe.Strategy.WinnerStrategy;

import TicTacToe.model.Board;
import TicTacToe.model.Move;
import TicTacToe.model.Player;

public interface CheckWinner {
    Player checkWinner(Board board , Move lastmove);
}
