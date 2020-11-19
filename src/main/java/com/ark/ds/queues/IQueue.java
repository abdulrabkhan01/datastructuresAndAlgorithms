package com.ark.ds.queues;

public interface IQueue<T> {
    void enqueue(T data);
    T dequeue();
    int size();
    boolean isEmpty();
}
