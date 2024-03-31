package queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import queue.exceptions.QueueOverflowException;
import queue.exceptions.QueueUnderflowException;
import stack.Stack;
import stack.exceptions.StackOverflowException;
import stack.exceptions.StackUnderflowException;

import static org.junit.jupiter.api.Assertions.*;

public class QueueTest {
    Queue queue;

    @BeforeEach
    public void buildStack(){
        this.queue = new Queue(3);
    }

    @Test
    public void stackMethodsTest(){
        int firstElement = 10;
        int secondElement = 11;
        int thirdElement = 12;

        assertNull(queue.head(), "It's doesn't returned null");
        assertTrue(queue.isEmpty(), "It's doesn't empty");
        assertFalse(queue.isFull(), "It's full");
        queue.enqueue(firstElement);
        queue.enqueue(secondElement);
        queue.enqueue(thirdElement);

        assertTrue(queue.isFull(), "It's doesn't full");
        assertFalse(queue.isEmpty(), "It's empty");

        assertThrows(QueueOverflowException.class, () -> queue.enqueue(12), "QueueOverflowException not thrown");

        assertEquals(firstElement, queue.head(), 0, "Different head");
        assertEquals(firstElement, queue.dequeue(), 0, "Different value dequeued");
        assertEquals(secondElement, queue.dequeue(), 0, "Different value dequeued");
        assertEquals(thirdElement, queue.head(), 0, "Different head");
        assertEquals(thirdElement, queue.dequeue(), 0, "Different value dequeued");
        assertNull(queue.head(), "Different head");

        assertTrue(queue.isEmpty(), "It's doesn't empty");
        assertFalse(queue.isFull(), "It's full");

        assertThrows(QueueUnderflowException.class, () -> queue.dequeue(), "StackOverflowException not thrown");
    }
}
