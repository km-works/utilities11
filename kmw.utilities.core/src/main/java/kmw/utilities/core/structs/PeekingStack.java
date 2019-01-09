package kmw.utilities.core.structs;

import kmw.utilities.core.services.ServicesManager;

import javax.annotation.Nonnull;
import java.util.Iterator;

/**
 * * @author Christian P. Lerch (christian.p.lerch[at]gmail.com)
 *
 * @param <T>
 */
public interface PeekingStack<T> extends Iterable<T> {

    static final int INITIAL_CAPACITY = 16;

    /* Convenience factory methods.
     * Useful when running on class-path instead of module-path, e.g. for local unit tests
     */
    static <T> PeekingStack<T> of() {
        return ServicesManager.getDefaultOrFail(PeekingStack.class);
    }

    static <T> PeekingStack<T> of(int initialSize) {
        PeekingStack<T> stack = PeekingStack.of();
        stack.ensureCapacity(initialSize);
        return stack;
    }

    void ensureCapacity(int newCapacity);

    /**
     * Push one item onto stack and increment item count
     *
     * @param item The item to be stacked
     */
    public void push(@Nonnull final T item);

    /**
     * Remove one item from top of stack and decrement item count
     *
     * @return Return item from top of stack
     */
    @Nonnull public T pop();

    /**
     * Read top of stack without changing the stack
     *
     * @return Return top of stack item
     */
    @Nonnull public T top();

    /**
     * Read any stack element without changing the stack
     *
     * @param pos
     * @return Return stack item at 0-based pos below top of stack
     */
    @Nonnull public T peek(final int pos);

    /**
     * Clear stack by popping all its items
     */
    public void clear();

    /**
     * Get number of currently stacked items
     *
     * @return Return stack size
     */
    public int size();

    /**
     * Test if stack is empty
     *
     * @return Return true if stack is empty
     */
    public boolean isEmpty();

    /**
     * Iterate over stacked items from top-of-stack down to bottom-of-stack (LIFO-mode)
     * @return LIFO-iterator
     */
    @Nonnull public Iterator<T> lifoIterator();

    /**
     * Iterate over stacked items from bottom-of-stack up to top-of-stack (FIFO-mode)
     * @return FIFO-iterator
     */
    @Nonnull public Iterator<T> fifoIterator();

}
