package TicTacToe.Controller;

import TicTacToe.Enums.GameStatus;
import TicTacToe.Enums.PlayerType;
import TicTacToe.Factory.WinnerCheckStrategyFactory;
import TicTacToe.Service.GameService;
import TicTacToe.Strategy.WinnerStrategy.WinnerCheckO1Strategy;
import TicTacToe.model.Board;
import TicTacToe.model.Game;
import TicTacToe.model.Move;
import TicTacToe.model.Player;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    private GameService gameService;

    public GameController(){
        this.gameService = new GameService();
    }
    public Game createGame(Board board, List<Player> players){
        int dimension = board.getDimension();
        return Game.builder()
                .setPlayers(players)
                .setCurrentPlayer(players.get(0))
                .setGameStatus(GameStatus.IN_PROGRESS)
                .setBoard(board)
                .setMoves(new ArrayList<>())
                .setBoardStates(new ArrayList<>())
                .setNumberOfMaps((2*dimension) + 3)
                .setPlayerType(PlayerType.HUMAN)
                .build();
    }
    public void displayBoard(Game game){
        game.getBoard().display();
    }
    public Move executeMove(Game game, Player player){
        return gameService.executeMove(game,player);
    }

    public Player checkWinner(Game game, Move lastPlayedMove){
        WinnerCheckO1Strategy strategy = WinnerCheckStrategyFactory.winnerStrategy(game.getBoard().getDimension());
        return strategy.checkWinner(game.getBoard(),lastPlayedMove);
    }

}
