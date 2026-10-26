package TicTacToe.Service;

import TicTacToe.Enums.CellState;
import TicTacToe.Enums.DifficultyLevel;
import TicTacToe.Enums.PlayerType;
import TicTacToe.Factory.BotPlayingStrategyFactory;
import TicTacToe.Strategy.BotStrategy.BotPlayingStrategy;
import TicTacToe.Strategy.BotStrategy.RandomBotPlayingStrategy;
import TicTacToe.model.Cell;
import TicTacToe.model.Game;
import TicTacToe.model.Move;
import TicTacToe.model.Player;
import java.util.*;

public class GameService {
    public Move executeMove(Game game, Player player){
        if(player.getPlayerType().equals(PlayerType.HUMAN)){
            return executeHumanPlayerMove(game,player);
        }else{
            return executeBotPlayerMove(game,player);
        }

    }

    public Move executeHumanPlayerMove(Game game, Player player){
        int temp = 0;
        while(temp != 1) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the target row : " + player.getName());
            int row = sc.nextInt();
            System.out.println("Enter the target col : " + player.getName());
            int col = sc.nextInt();

            Cell playedMoveCell = game.getBoard().getMatrix().get(row).get(col);
            if (playedMoveCell.getCellState().equals(CellState.EMPTY)) {
                playedMoveCell.setPlayer(player);
                playedMoveCell.setCellState(CellState.FILLED);
                temp = 1;
                return new Move(playedMoveCell, player);
            } else {
                System.out.println("cell is already filled, enter the valid cell to continue the game");
            }
        }

        return null;
    }

    public Move executeBotPlayerMove(Game game, Player botPlayer){
        RandomBotPlayingStrategy botPlayingStrategy = BotPlayingStrategyFactory.botPlayer(DifficultyLevel.MEDIUM);
        return botPlayingStrategy.takeMove(game.getBoard(), botPlayer);
    }
}
