package kmw.utilities.core.structs;

import com.google.inject.Guice;
import com.google.inject.Injector;
import kmw.utilities.core.UtilitiesCoreModule;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class PeekingStackInjectorTest {

    private static Injector injector;

    @BeforeClass
    public static void setUp() {
        injector = Guice.createInjector(new UtilitiesCoreModule());
    }

    @Test
    public void testInjector_01() {
        PeekingStack<Integer> stack = injector.getInstance(PeekingStack.class);
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

}
