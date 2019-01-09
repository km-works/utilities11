package kmw.utilities.core.structs.impl;

import com.google.common.collect.AbstractIterator;
import kmw.utilities.core.services.ManagedService;
import kmw.utilities.core.structs.PeekingStack;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Iterator;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static kmw.utilities.core.strings.StringPool.*;

/**
 * An expanding, typed, peekable and iterable stack implemented as a fast ArrayList.
 *
 * <b>Note that this implementation is not synchronized and thus NOT THREAD-SAFE.</b>
 * If multiple threads access an ArrayList instance concurrently, and at least one of the threads modifies the list
 * structurally, it must be synchronized externally.
 * (A structural modification is any operation that adds or deletes one or more elements, or explicitly resizes the
 * backing array; merely setting the value of an element is not a structural modification.)
 *
 * @author Christian P. Lerch (christian.p.lerch[at]gmail.com)
 * @version 1.0.0
 * @since 1.0
 * @param <T> Type of stack item
 */
@ManagedService(serviceName = "PEEKING_ARRAY_LIST_STACK", isDefaultService = true)
public final class PeekingArrayListStack<T> implements PeekingStack<T> {

    private final ArrayList<T> backingArrayList;
    private int capacity;
    private int itemCount;

    /**
     * Create an expandable stack of <code>T</code>-items
     */
    public PeekingArrayListStack() {
        capacity = INITIAL_CAPACITY;
        backingArrayList = new ArrayList<>(capacity);
        itemCount = 0;
    }

    @Override
    public void ensureCapacity(int newCapacity) {
        if (newCapacity > capacity) {
            backingArrayList.ensureCapacity(newCapacity);
        }
    }

    private void expandCapacityBy(int capacityIncrement) {
        checkArgument(capacityIncrement > 0);
        capacity += capacityIncrement;
        ensureCapacity(capacity);
    }

    /**
     * Push one item onto the stack and increment item count
     *
     * @param item The item to be stacked
     */
    @Override
    public void push(@Nonnull final T item) {
        checkNotNull(item, format(Messages_.PARAM_1_2_MUST_NOT_BE_NULL, 1, "item"));
        if (itemCount == capacity) {
            expandCapacityBy(capacity);     // double capacity
        }
        backingArrayList.add(null);
        backingArrayList.set(itemCount, item);
        itemCount++;
    }

    /**
     * Remove one item from top of stack and decrement item count
     *
     * @return Return item from top of stack
     */
    @Override
    @Nonnull public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        itemCount--;
        final T result = backingArrayList.get(itemCount);
        backingArrayList.set(itemCount, null);
        return result;
    }

    /**
     * Read top of stack without changing the stack
     *
     * @return Return top of stack item
     */
    @Override
    @Nonnull public T top() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return peek(0);
    }

    /**
     * Return any stack element without changing the stack.
     *
     * @param pos position of stack item to return; pos => 0 returns top of stack.
     * @return Return stack item at <pos> below top of stack
     */
    @Override
    @Nonnull public T peek(final int pos) {
        if (itemCount - pos - 1 < 0) {
            throw new EmptyStackException();
        }
        return backingArrayList.get(itemCount - pos - 1);
    }

    /**
     * Clear all items from stack
     */
    @Override
    public void clear() {
        while (itemCount > 0) {
            backingArrayList.set(itemCount - 1, null);
            itemCount--;
        }
    }

    /**
     * Get number of currently stacked items
     *
     * @return Return stack size
     */
    @Override
    public int size() {
        return itemCount;
    }

    /**
     * Test if stack is empty
     *
     * @return Return <code>true</code> if stack is empty
     */
    @Override
    public boolean isEmpty() {
        return itemCount == 0;
    }

    @Override
    @Nonnull public Iterator<T> iterator() {
        return lifoIterator();
    }

    /**
     * Iterate over stacked items from top-of-stack down to bottom-of-stack (LIFO-mode)
     * @return LIFO-iterator
     */
    @Override
    @Nonnull public Iterator<T> lifoIterator() {
        return new AbstractIterator<T>() {
            int pos = 0;
            @Override
            protected T computeNext() {
                if (pos < itemCount) {
                    return PeekingArrayListStack.this.peek(pos++);
                } else {
                    return endOfData();
                }
            }
        };
    }

    /**
     * Iterate over stacked items from bottom-of-stack up to top-of-stack (FIFO-mode)
     * @return FIFO-iterator
     */
    @Override
    @Nonnull public Iterator<T> fifoIterator() {
        return new AbstractIterator<T>() {
            int pos = itemCount - 1;
            @Override
            protected T computeNext() {
                if (pos >= 0) {
                    return PeekingArrayListStack.this.peek(pos--);
                } else {
                    return endOfData();
                }
            }
        };
    }

}
