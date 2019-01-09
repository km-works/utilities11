package kmw.utilities.core.structs;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class PeekingStackTest {

    @Test
    public void testIterators() {
        PeekingStack<Integer> stack = PeekingStack.of(32);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertTrue(3 == stack.top());
        assertTrue(2 == stack.peek(1));
        assertTrue(1 == stack.peek(2));
        assertEquals(3, stack.size());

        Iterator<Integer> it1 = stack.lifoIterator();
        assertTrue(it1.hasNext());
        assertTrue(3 == it1.next());
        assertTrue(it1.hasNext());
        assertTrue(2 == it1.next());
        assertTrue(it1.hasNext());
        assertTrue(1 == it1.next());
        assertFalse(it1.hasNext());
        assertFalse(stack.isEmpty());

        Iterator<Integer> it2 = stack.fifoIterator();
        assertTrue(it2.hasNext());
        assertTrue(1 == it2.next());
        assertTrue(it2.hasNext());
        assertTrue(2 == it2.next());
        assertTrue(it2.hasNext());
        assertTrue(3 == it2.next());
        assertFalse(it2.hasNext());
        assertFalse(stack.isEmpty());
    }

    @Test(expected = java.util.EmptyStackException.class)
    public void testThrowEmptyStackException_01() {
        PeekingStack<Integer> stack = PeekingStack.of();
        stack.top();
    }

    @Test(expected = java.util.EmptyStackException.class)
    public void testThrowEmptyStackException_02() {
        PeekingStack<Integer> stack = PeekingStack.of();
        stack.pop();
    }

    @Test(expected = java.util.EmptyStackException.class)
    public void testThrowEmptyStackException_03a() {
        PeekingStack<Integer> stack = PeekingStack.of();
        stack.peek(1);
    }

    @Test(expected = java.util.EmptyStackException.class)
    public void testThrowEmptyStackException_03b() {
        PeekingStack<Integer> stack = PeekingStack.of();
        stack.push(1);
        stack.peek(2);
    }

    @Test
    public void testClearStack() {
        PeekingStack<Integer> stack = PeekingStack.of();
        stack.push(1);
        stack.push(2);
        assertFalse(stack.isEmpty());
        assertEquals(2, stack.size());
        stack.clear();
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
    }

    @Test(expected = NullPointerException.class)
    public void testPushNullItem() {
        PeekingStack<Integer> stack = PeekingStack.of();
        stack.push(null);
    }
}