package com.ark.ds.queues;


import java.util.Stack;

/**
 * <p> Queue data structure implemented using two Stacks. </p>
 * @param <T>
 */
public class QueueUsingStacks<T> implements IQueue<T> {

    private final Stack<T> stackWithNewerElements = new Stack<>();
    private final Stack<T> stackWithOlderElements = new Stack<>();

    @Override
    public void enqueue(T data) {
        stackWithNewerElements.push(data);
    }

    @Override
    public T dequeue() {
        if (stackWithOlderElements.isEmpty()) {
            while(!stackWithNewerElements.isEmpty()) {
                stackWithOlderElements.push(stackWithNewerElements.pop());
            }
        }
        return stackWithOlderElements.isEmpty() ? null : stackWithOlderElements.pop();
    }
}
