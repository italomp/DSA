package stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stack.exceptions.StackOverflowException;
import stack.exceptions.StackUnderflowException;

import static org.junit.jupiter.api.Assertions.*;

public class StackTest {
    Stack stack;

    @BeforeEach
    public void buildStack(){
        this.stack = new Stack(3);
    }

    @Test
    public void stackMethodsTest(){
        int firstElement = 10;
        int secondElement = 11;
        int thirdElement = 12;

        assertNull(stack.top(), "It's doesn't returned null");
        assertTrue(stack.isEmpty(), "It's doesn't empty");
        assertFalse(stack.isFull(), "It's full");
        stack.push(firstElement);
        stack.push(secondElement);
        stack.push(thirdElement);

        assertTrue(stack.isFull(), "It's doesn't full");
        assertFalse(stack.isEmpty(), "It's empty");

        assertThrows(StackOverflowException.class, () -> stack.push(12), "StackOverflowException not thrown");

        assertEquals(thirdElement, stack.top(), 0, "Different top");
        assertEquals(thirdElement, stack.pop(), 0, "Different value popped");

        assertEquals(secondElement, stack.top(), 0, "Different top");
        assertEquals(secondElement, stack.pop(), 0, "Different value popped");

        assertEquals(firstElement, stack.top(), 0, "Different top");
        assertEquals(firstElement, stack.pop(), 0, "Different value popped");

        assertTrue(stack.isEmpty(), "It's doesn't empty");
        assertFalse(stack.isFull(), "It's full");

        assertThrows(StackUnderflowException.class, () -> stack.pop(), "StackOverflowException not thrown");
    }
}
