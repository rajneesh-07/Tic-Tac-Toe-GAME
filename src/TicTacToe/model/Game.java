package TicTacToe.model;

import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private Player currentPlayer;
    private GameStatus gameStatus;
    private List<Move> moves;
    private List<Board> boardStates;
    private int numberOfMaps;

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


       public Builder() {
       }

       public Builder setBoard() {
           this.board = board;
           return this;
       }

       public Builder setPlayers() {
           this.players = players;
           return this;
       }

       public Builder setCurrentPlayer() {
           this.currentPlayer = currentPlayer;
           return this;
       }

       public Builder setGameStatus() {
           this.gameStatus = gameStatus;
           return this;
       }

       public Builder setMoves() {
           this.moves = moves;
           return this;
       }

       public Builder setBoardStates() {
           this.boardStates = boardStates;
           return this;
       }

       public Builder setNumberOfMaps() {
           this.numberOfMaps = numberOfMaps;
           return this;
       }

       public void validate(){
//            if(players.size() != ){
//                throw InvalidNumberOfPlayerException("Invalid players");
//            }
//            if(){
//                throw DuplicateSymbolException("Duplicate symbol");
//            }
       }
       public Game build(){
           validate();
           return new Game(board,players,currentPlayer,gameStatus,moves,boardStates,numberOfMaps);
       }
   }
}
