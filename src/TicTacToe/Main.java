package TicTacToe;

import TicTacToe.Controller.GameController;
import TicTacToe.Enums.CellState;
import TicTacToe.Enums.DifficultyLevel;
import TicTacToe.Enums.GameStatus;
import TicTacToe.Enums.PlayerType;
import TicTacToe.Exception.DrawMatchException;
import TicTacToe.model.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//      Board board = new Board(3);
//      board.display();
        int id = 1;
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Tic-Tac-Toe!");
        System.out.print("Enter the dimension of the board : ");
        int dimension = sc.nextInt();
        GameController gameController = new GameController();
        ArrayList<Player> players = new ArrayList<>();
        System.out.println("Do you want bot player?, Y for yes, N for no");
        String st = sc.next();
        if(st.equalsIgnoreCase("Y")){
            Bot botPlayer = new Bot(id++,"BOT",'B', DifficultyLevel.MEDIUM);
            players.add(botPlayer);
        }

        while(id<dimension){
            System.out.println("Enter the name of the player");
            String name = sc.next();
            System.out.println("Enter the symbol of the player");
            char symbol = sc.next().charAt(0);
            Player player = new Player(id++,name,symbol, PlayerType.HUMAN);
            players.add(player);
        }
        Collections.shuffle(players);

    Board board = new Board(dimension);
    Game game = gameController.createGame(board,players);
    int playerIndex = -1;
    while(game.getGameStatus().equals(GameStatus.IN_PROGRESS)){
      System.out.println("Current Board State ");
      gameController.displayBoard(game);
      playerIndex++;
      playerIndex = playerIndex % players.size();

      Move move = gameController.executeMove(game,players.get(playerIndex));
      game.getMoves().add(move);
      game.getBoardStates().add(game.getBoard());

      try{
          Player player = gameController.checkWinner(game,move);

          if(player != null){
              System.out.println("WINNER IS : "+ players.get(playerIndex).getName());
              break;
          }
        }catch (DrawMatchException exception){
          System.out.println("Match is drawn!");
          break;
        }
      }
    System.out.println("Final board state");
    board.display();
    }
}