package com.ark.ds.queues;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <p> Spec to test Queue implemented using Stacks.</p>
 *
 * @author AbdulR
 */
public class QueueUsingLinkListSpec {

    @Test
    public void queueSpec1() {
        IQueue<Integer> queue = new QueueUsingSinglyLinkList<>();
        queue.enqueue(1);
        assertEquals(1, queue.dequeue());
    }

    @Test
    public void queueSpec2() {
        IQueue<Integer> queue = new QueueUsingSinglyLinkList<>();
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(1, queue.dequeue());
    }

    @Test
    public void queueSpec3() {
        IQueue<Integer> queue = new QueueUsingSinglyLinkList<>();
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(1, queue.dequeue());
        queue.enqueue(3);
        assertEquals(2, queue.dequeue());
    }


}
