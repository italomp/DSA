package stack;

import stack.exceptions.StackOverflowException;
import stack.exceptions.StackUnderflowException;

public class Stack {
    private Integer[] array;
    private Integer top;

    public Stack (int length){
        this.array = new Integer[length];
        this.top = -1;
    }

    public void push(int element){
        if(isFull()){
            throw new StackOverflowException("stack is full");
        }
        array[++top] = element;
    }

    public Integer pop(){
        if(isEmpty()){
            throw new StackUnderflowException("stack is empty");
        }
        int result = this.array[top];
        this.array[top--] = null;
        return result;
    }

    public Integer top() throws ArrayIndexOutOfBoundsException {
        if(isEmpty()){
            return null;
        }
        return this.array[top];
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top == array.length -1;
    }
}
