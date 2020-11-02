package com.ark.ds.stacks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Stack implementation { not full implementation, this is being developed using TDD :)}
 * @param <E>
 * @author AbdulRabKhan
 */
public class Stack<E> implements  IStack<E> {
    private transient List<E> stackElements = Collections.emptyList();
    private int size = 0;

    public Stack(int capacity) {
        super();
        stackElements = new ArrayList<>(capacity);
    }

    public void push(E e) {
        stackElements.add(e);
        size++;
    }

    public E pop() {
        if (isEmpty()) {
            throw new ElementNotFoundException("Stack is Empty");
        }
        E element = stackElements.remove(size-1);
        --size;
        return element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }
}
