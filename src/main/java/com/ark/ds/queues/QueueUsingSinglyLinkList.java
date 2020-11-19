package com.ark.ds.queues;

/**
 * <p> Queue using Singly Link List.</p>
 *
 * @param <T>
 * @author AbdulR
 */
public class QueueUsingSinglyLinkList<T> implements IQueue<T> {
    private Node head, tail;
    private int size = 0;

    @Override
    public void enqueue(T data) {
        size++;
        addAtTailOfList(data);
    }

    private void addAtTailOfList(T data) {
        Node node = new Node(data);
        if (tail == null) {
            head = tail = node;
            return;
        }
        tail.next = node;
        tail = node;
    }

    @Override
    public T dequeue() {
        --size;
        //No Element
        return removeFromHead();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private T removeFromHead() {
        if (head == null) return null;
        //Single Element
        if (head == tail) {
            Node temp = head;
            head = tail = null;
            return temp.data;
        }
        //Otherwise
        Node temp = head;
        head = temp.next;
        return temp.data;
    }

    private class Node {
        T data;
        Node next;

        public Node(T data) {
            this.data = data;
        }
    }
}
