package queue;

import queue.exceptions.QueueOverflowException;
import queue.exceptions.QueueUnderflowException;

public class Queue {
    private final Integer[] array;
    private final int  head;
    private int  tail;

    public Queue(int length){
        this.array = new Integer[length];
        this.head = 0;
        this.tail = -1;
    }

    public boolean isEmpty(){
        return this.tail == -1;
    }

    public boolean isFull(){
        return this.tail == this.array.length -1;
    }

    public void enqueue(int element){
        if(isFull()){
            throw new QueueOverflowException("Queue is full");
        }
        this.array[++tail] = element;
    }

    public Integer dequeue(){
        if(isEmpty()){
            throw new QueueUnderflowException("Queue is empty");
        }
        int result = this.array[head];

        for(int i = 0; i < tail; i++){
            this.array[i] = this.array[i + 1];
        }
        this.array[tail--] = null;
        return result;
    }

    public Integer head(){
        if(isEmpty()){
            return null;
        }
        return this.array[head];
    }
}
