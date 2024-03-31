package queue.exceptions;

public class QueueOverflowException extends RuntimeException{
    public QueueOverflowException(String msg){
        super(msg);
    }
}
