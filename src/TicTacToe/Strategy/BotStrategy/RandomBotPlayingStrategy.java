package TicTacToe.Strategy.BotStrategy;

import TicTacToe.Enums.CellState;
import TicTacToe.Exception.DrawMatchException;
import TicTacToe.model.Board;
import TicTacToe.model.Cell;
import TicTacToe.model.Move;
import TicTacToe.model.Player;

import java.util.List;

import static TicTacToe.Enums.CellState.EMPTY;

public class RandomBotPlayingStrategy implements BotPlayingStrategy{

    @Override
    public Move takeMove(Board board, Player player){
        List<List<Cell>> matrix = board.getMatrix();
        for(int i = 0; i<matrix.size(); i++){
            for(int j = 0; j < matrix.get(i).size(); j++){
                if(matrix.get(i).get(j).getCellState().equals(CellState.EMPTY)){
                    matrix.get(i).get(j).setCellState(CellState.FILLED);
                    matrix.get(i).get(j).setPlayer(player);
                    return new Move(matrix.get(i).get(j),player);
                }
            }
        }
        throw new DrawMatchException("There is no empty cell left");
    }
}
