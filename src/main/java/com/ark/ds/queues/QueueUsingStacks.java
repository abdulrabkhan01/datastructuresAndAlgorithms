package com.ark.ds.queues;


import java.util.Stack;

/**
 * <p> Queue data structure implemented using two Stacks. </p>
 *
 * @param <T>
 */
public class QueueUsingStacks<T> implements IQueue<T> {

    private final Stack<T> stackWithNewerElements = new Stack<>();
    private final Stack<T> stackWithOlderElements = new Stack<>();
    private int size = 0;

    @Override
    public void enqueue(T data) {
        size++;
        stackWithNewerElements.push(data);
    }

    @Override
    public T dequeue() {
        size--;
        if (stackWithOlderElements.isEmpty()) {
            while (!stackWithNewerElements.isEmpty()) {
                stackWithOlderElements.push(stackWithNewerElements.pop());
            }
        }
        return stackWithOlderElements.isEmpty() ? null : stackWithOlderElements.pop();
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
