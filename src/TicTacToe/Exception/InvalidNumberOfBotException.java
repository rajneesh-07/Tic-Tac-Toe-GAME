package TicTacToe.Exception;

public class InvalidNumberOfBotException extends RuntimeException{
    public InvalidNumberOfBotException(String message){
        super(message);
    }
    public InvalidNumberOfBotException(String message, Throwable cause){
        super(message, cause);
    }
}
