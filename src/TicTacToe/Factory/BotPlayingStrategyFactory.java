package TicTacToe.Factory;

import TicTacToe.Enums.DifficultyLevel;
import TicTacToe.Strategy.BotStrategy.BotPlayingStrategy;
import TicTacToe.Strategy.BotStrategy.RandomBotPlayingStrategy;

public class BotPlayingStrategyFactory {

    public static RandomBotPlayingStrategy botPlayer(DifficultyLevel difficultyLevel){
        return new RandomBotPlayingStrategy();
    }
}
