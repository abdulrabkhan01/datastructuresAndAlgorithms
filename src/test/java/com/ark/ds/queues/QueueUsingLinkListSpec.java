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
        IQueue<Integer> queueUsingStacks = new QueueUsingSinglyLinkList<>();
        queueUsingStacks.enqueue(1);
        assertEquals(1, queueUsingStacks.dequeue());
    }

    @Test
    public void queueSpec2() {
        IQueue<Integer> queueUsingStacks = new QueueUsingSinglyLinkList<>();
        queueUsingStacks.enqueue(1);
        queueUsingStacks.enqueue(2);
        assertEquals(1, queueUsingStacks.dequeue());
    }

    @Test
    public void queueSpec3() {
        IQueue<Integer> queueUsingStacks = new QueueUsingSinglyLinkList<>();
        queueUsingStacks.enqueue(1);
        queueUsingStacks.enqueue(2);
        assertEquals(1, queueUsingStacks.dequeue());
        queueUsingStacks.enqueue(3);
        assertEquals(2, queueUsingStacks.dequeue());
    }


}
