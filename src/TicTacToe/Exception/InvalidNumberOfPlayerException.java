package TicTacToe.Exception;

public class InvalidNumberOfPlayerException extends RuntimeException {
    public InvalidNumberOfPlayerException(){}

    public InvalidNumberOfPlayerException(String message){
        super(message);
    }

    public InvalidNumberOfPlayerException(String message, Throwable cause){
        super(message,cause);
    }

}
