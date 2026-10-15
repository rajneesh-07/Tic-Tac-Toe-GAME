package TicTacToe.Strategy.WinnerStrategy;

import TicTacToe.model.Board;
import TicTacToe.model.Move;
import TicTacToe.model.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WinnerCheckO1Strategy implements CheckWinner{
    private int dimension;
    private List<HashMap<Character,Integer>> rowmapList;
    private List<HashMap<Character,Integer>> colmapList;
    private HashMap<Character,Integer> leftDiagonalMap;
    private HashMap<Character,Integer> rightDiagonalMap;
    private HashMap<Character, Integer> cornerMap;

    public WinnerCheckO1Strategy(int dimension){
        this.dimension = dimension;
        this.rowmapList = new ArrayList<>();
        this.colmapList = new ArrayList<>();
        this.leftDiagonalMap = new HashMap<>();
        this.rightDiagonalMap = new HashMap<>();
        this.cornerMap = new HashMap<>();
    }

    @Override
    public Player checkWinner(Board board, Move lastMove){
        Player player = lastMove.getPlayer();
        char symbol = lastMove.getPlayer().getSymbol();
        int row = lastMove.getCell().getRow();
        int col = lastMove.getCell().getCol();

        boolean winner =
    }

    public boolean 
}
