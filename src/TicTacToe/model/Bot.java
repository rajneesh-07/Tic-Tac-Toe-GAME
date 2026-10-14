package TicTacToe.model;

import TicTacToe.Enums.DifficultyLevel;
import TicTacToe.Enums.PlayerType;

public class Bot extends  Player{
    private DifficultyLevel difficultyLevel;

    public Bot(DifficultyLevel difficultyLevel){
        this.difficultyLevel = difficultyLevel;
    }

    public Bot(int id, String name, char symbol, DifficultyLevel difficultyLevel){
        super(id,name,symbol, PlayerType.BOT);
        this.difficultyLevel = difficultyLevel;
    }
}
