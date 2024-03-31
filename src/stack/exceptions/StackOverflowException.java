package stack.exceptions;

public class StackOverflowException extends RuntimeException{
    public StackOverflowException(String msg){
        super(msg);
    }
}
