package TicTacToe.model;

import TicTacToe.Enums.GameStatus;
import TicTacToe.Enums.PlayerType;
import TicTacToe.Exception.DuplicateSymbolException;
import TicTacToe.Exception.InvalidNumberOfBotException;
import TicTacToe.Exception.InvalidNumberOfPlayerException;

import java.util.HashSet;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private Player currentPlayer;
    private GameStatus gameStatus;
    private List<Move> moves;
    private List<Board> boardStates;
    private int numberOfMaps;
    private PlayerType playerType;

   private Game(Board board, List<Player> players, Player currentPlayer, GameStatus gameStatus,
                List<Move> moves, List<Board> boardStates, int numberOfMaps ){
       this.board = board;
       this.players = players;
       this.currentPlayer = currentPlayer;
       this.gameStatus = gameStatus;
       this.moves = moves;
       this.boardStates = boardStates;
       this.numberOfMaps = numberOfMaps;
   }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public List<Board> getBoardStates() {
        return boardStates;
    }

    public void setBoardStates(List<Board> boardStates) {
        this.boardStates = boardStates;
    }

    public int getNumberOfMaps() {
        return numberOfMaps;
    }

    public void setNumberOfMaps(int numberOfMaps) {
        this.numberOfMaps = numberOfMaps;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public static Builder builder(){
       return new Builder();
   }

   public static class Builder {
       private Board board;
       private List<Player> players;
       private Player currentPlayer;
       private GameStatus gameStatus;
       private List<Move> moves;
       private List<Board> boardStates;
       private int numberOfMaps;
       private  PlayerType playerType;


       public Builder() {
       }

       public Builder setBoard(Board board) {
           this.board = board;
           return this;
       }

       public Builder setPlayers(List<Player> players) {
           this.players = players;
           return this;
       }

       public Builder setCurrentPlayer(Player currentPlayer) {
           this.currentPlayer = currentPlayer;
           return this;
       }

       public Builder setGameStatus(GameStatus gameStatus) {
           this.gameStatus = gameStatus;
           return this;
       }

       public Builder setMoves(List<Move> moves) {
           this.moves = moves;
           return this;
       }

       public Builder setBoardStates(List<Board> boardStates) {
           this.boardStates = boardStates;
           return this;
       }

       public Builder setNumberOfMaps(int numberOfMaps) {
           this.numberOfMaps = numberOfMaps;
           return this;
       }
       public Builder setPlayerType(PlayerType playerType){
           this.playerType = playerType;
           return this;
       }

       public boolean isDuplicate(){
           HashSet<Character> set = new HashSet<>();
           for(Player player : players){
               set.add(player.getSymbol());
           }
           if(set.size() != players.size()){
               throw new DuplicateSymbolException("Duplicate symbol exist");
           }else{
               return true;
           }
       }
       public boolean isValidPlayers(){
           int temp = 0;
           int count = 0;
           for(int i = 0; i<players.size(); i++){

               if(playerType == PlayerType.BOT){
                   count++;
                   temp++;
               }else{
                   temp++;
               }
           }
           if(count > 1){
               throw new InvalidNumberOfBotException("There are more then 1 bot player");
           }
           if(temp != board.getDimension()-1){
               throw new InvalidNumberOfPlayerException("There are insufficient player");
           }else{
               return true;
           }
       }
       public void validate(){
           isDuplicate();
           isValidPlayers();
       }
       public Game build(){
           validate();
           return new Game(board,players,currentPlayer,gameStatus,moves,boardStates,numberOfMaps);
       }
   }
}
