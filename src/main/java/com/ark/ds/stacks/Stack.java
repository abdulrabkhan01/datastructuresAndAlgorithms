package com.ark.ds.stacks;

import java.util.ArrayList;
import java.util.List;

/**
 * Stack implementation { not full implementation, this is being developed using TDD :)}
 *
 * @param <E>
 * @author AbdulRabKhan
 */
public class Stack<E> implements IStack<E> {
    private transient final List<E> stackElements;
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;

    public Stack(int capacity) {
        super();
        stackElements = new ArrayList<>(capacity);
    }

    public Stack() {
        super();
        stackElements = new ArrayList<>(DEFAULT_CAPACITY);
    }

    public void push(E e) {
        stackElements.add(e);
        size++;
    }

    public E pop() {
        if (isEmpty()) {
            throw new ElementNotFoundException("Stack is Empty");
        }
        return stackElements.remove(--size);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
