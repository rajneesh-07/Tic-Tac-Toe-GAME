package TicTacToe.Exception;

public class DrawMatchException extends RuntimeException{
    public DrawMatchException(String message){
        super(message);
    }

    public DrawMatchException(String message, Throwable cause){
        super(message,cause);
    }
}
