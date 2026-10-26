package TicTacToe.Strategy.WinnerStrategy;

import TicTacToe.Exception.DrawMatchException;
import TicTacToe.model.Board;
import TicTacToe.model.Move;
import TicTacToe.model.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//import static com.sun.tools.javac.tree.TreeInfo.symbol;

public class WinnerCheckO1Strategy implements CheckWinner{
    public static WinnerCheckO1Strategy instance;
    private int dimension;
    private int eligibleMapForWinning;
    private int cellCount;
    private List<HashMap<Character,Integer>> rowmapList;
    private List<HashMap<Character,Integer>> colmapList;
    private HashMap<Character,Integer> leftDiagonalMap;
    private HashMap<Character,Integer> rightDiagonalMap;
    private HashMap<Character, Integer> cornerMap;

    public WinnerCheckO1Strategy(int dimension){
        this.dimension = dimension;
        this.cellCount = dimension*dimension;
        this.eligibleMapForWinning = ((2*dimension) + 3);
        this.rowmapList = new ArrayList<>();
        this.colmapList = new ArrayList<>();
        this.leftDiagonalMap = new HashMap<>();
        this.rightDiagonalMap = new HashMap<>();
        this.cornerMap = new HashMap<>();
        for(int i = 0; i<dimension; i++){
            rowmapList.add(new HashMap<>());
            colmapList.add(new HashMap<>());
        }
    }

    public static WinnerCheckO1Strategy getInstance(int dimension){
        if(instance == null){
            instance = new WinnerCheckO1Strategy(dimension);
        }
        return instance;
    }

    @Override
    public Player checkWinner(Board board, Move lastMove){
        Player player = lastMove.getPlayer();
        char symbol = lastMove.getPlayer().getSymbol();
        int row = lastMove.getCell().getRow();
        int col = lastMove.getCell().getCol();

        boolean winner = updateRow(row,symbol) ||
                         updateCol(col,symbol) ||
                         (checkForLeftDiagonal(row,col) && updateLeftDiagonal(symbol)) ||
                         (checkForRightDiagonal(row,col) && updateRightDiagonal(symbol)) ||
                         (checkForCorner(row,col) && updateCorner(symbol));

        if(winner){
            return player;
        }else{
            drawCheck();
            return null;
        }

    }

    public boolean checkForLeftDiagonal(int row, int col){
        return row == col;
    }
    public boolean checkForRightDiagonal(int row, int col){
        return (row + col) == dimension - 1;
    }
    public boolean checkForCorner(int row, int col){
        return (row == 0 && col == 0) ||
                (row == 0 && col == dimension -1) ||
                (row == dimension -1 && col == 0) ||
                (row == dimension -1 && col == dimension -1);
    }

    public boolean updateRow(int row,char symbol){
        HashMap<Character,Integer> rowMap = rowmapList.get(row);
        cellCount--;
        if(rowMap.containsKey(symbol)){
            rowMap.put(symbol,rowMap.get(symbol) +1);
            if(rowMap.keySet().size() > 1){
                eligibleMapForWinning--;
            }
            return rowMap.get(symbol) == dimension;
        }else{
            rowMap.put(symbol,1);
        }
        return false;
    }

    public boolean updateCol(int col, char symbol){
        HashMap<Character, Integer> colMap = colmapList.get(col);

        if(colMap.containsKey(symbol)){
            colMap.put(symbol, colMap.get(symbol)+1);

            if(colMap.keySet().size() > 1){
                eligibleMapForWinning--;
            }
            return colMap.get(symbol) == dimension;
        }
        else{
            colMap.put(symbol, 1);
        }
        return false;
    }

    public boolean updateLeftDiagonal(char symbol){
        if(leftDiagonalMap.containsKey(symbol)){
            leftDiagonalMap.put(symbol,leftDiagonalMap.get(symbol) + 1);
            if(leftDiagonalMap.keySet().size() > 1){
                eligibleMapForWinning--;
            }
            return leftDiagonalMap.get(symbol) == dimension;
        }
        else{
            leftDiagonalMap.put(symbol,1);
        }
        return false;
    }

    public boolean updateRightDiagonal(char symbol){
        if(rightDiagonalMap.containsKey(symbol)){
            rightDiagonalMap.put(symbol, rightDiagonalMap.get(symbol) + 1);

            if(rightDiagonalMap.keySet().size() > 1){
                eligibleMapForWinning--;
            }
            return rightDiagonalMap.get(symbol) == dimension;
        }else{
            rightDiagonalMap.put(symbol, 1);
        }
        return false;
    }

    public boolean updateCorner(char symbol){
        if(cornerMap.containsKey(symbol)){
            cornerMap.put(symbol, cornerMap.get(symbol) + 1);
            if(cornerMap.keySet().size() > 1){
                eligibleMapForWinning--;
            }
            return cornerMap.get(symbol) == dimension;
        }else{
            cornerMap.put(symbol, 1);
        }
        return false;
    }

    public void drawCheck(){
        if(eligibleMapForWinning == 0 || cellCount == 0){
            throw new DrawMatchException("MATCH DRAW");
        }
    }
}
