package TicTacToe.Factory;

import TicTacToe.Strategy.WinnerStrategy.WinnerCheckO1Strategy;

public class WinnerCheckStrategyFactory {

    public static WinnerCheckO1Strategy winnerStrategy(int dimension){
        return WinnerCheckO1Strategy.getInstance(dimension);
    }
}
