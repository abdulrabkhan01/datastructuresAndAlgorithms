package com.ark.ds.lrucache;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p> Lease Recently Used cache implementation. Will be using Doubly linked list to
 * store the most recently used Node at the Head of the the List and to remove the
 * least recently used node from the Tail of the List.</p>
 *
 * @author AbdulR
 */
public class LRUCache<K, V> implements ILRUCache<K, V> {
    private int size = 0;
    private final int capacity;
    //Map bounded by max capacity defined by the constructor.
    private final transient Map<K, LinkedListNode<K, V>> leastRecentlyUsedMap ;
    //Head of the Linked List
    private LinkedListNode<K,V> head = null;
    //Tail of the Linked List
    private LinkedListNode<K,V> tail = null;

    public LRUCache(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than or equal to zero");
        }
        this.capacity = capacity;
        this.leastRecentlyUsedMap = new ConcurrentHashMap<>(capacity);
    }

    @Override
    public void put(K key, V value) {
        //If key already present in Map then move it to the head of the list
        LinkedListNode<K, V> existingNode = leastRecentlyUsedMap.get(key);
        if (existingNode == null) {
            //If Key is not present add it as Head Node
            LinkedListNode<K, V> newNode = new LinkedListNode<>(key, value);
            addNewNode(newNode);
            leastRecentlyUsedMap.put(key, newNode);
        } else {
            handleAlreadyPresentNode(value, existingNode);
        }
    }

    private void handleAlreadyPresentNode(V value, LinkedListNode<K, V> existingNode) {
        //Remove from the current Position
        LinkedListNode<K,V> prev = existingNode.prev;
        LinkedListNode<K,V> next = existingNode.next;
        if (prev != null) {
            prev.next = next;
            if (existingNode == tail) {
                tail = prev;
            }
        }
        if(next != null) {
            next.prev = prev;
        }

        //Update with new value for the key
        existingNode.data = value;
        //Add node to Head
        moveNodeToHead(existingNode);
    }

    private void addNewNode(LinkedListNode<K, V> node) {
        if (size + 1 > capacity) {
            //Check if adding new item causes size to goes out of the capacity
            //Remove from Map
            leastRecentlyUsedMap.remove(tail.key);
            //Remove tail from the List
            LinkedListNode<K, V> prev = tail.prev;
            if (prev != null) {
                prev.next = null;
            }
            tail = prev;

        } else {
            size++;
        }
        moveNodeToHead(node);
    }

    private void moveNodeToHead(LinkedListNode<K, V> node) {
        if (node==head) { //If already head then return
            return;
        }
        if (head == null) {
            head = tail = node;
        } else {
            //Add as Head of the List
            node.next = head;
            head.prev = node;
            node.prev = null;
            head = node;
        }
    }

    @Override
    public V get(K key) {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cache is Empty");
        }
        V value = null;
        //Move the Node to the front before returning value
        LinkedListNode<K, V> existingNode = leastRecentlyUsedMap.get(key);
        if (existingNode != null) {
            removeNode(existingNode); //Remove from current position
            moveNodeToHead(existingNode); //Move to head
            value = existingNode.data;
        }
        return value;
    }

    private void removeNode(LinkedListNode<K, V> existingNode) {
        LinkedListNode<K, V> prev = existingNode.prev;
        LinkedListNode<K, V> next = existingNode.next;
        if (prev != null) {
            prev.next = next;
        }
        if (next != null) {
            next.prev = prev;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(K key) {
        return leastRecentlyUsedMap.containsKey(key);
    }

    @Override
    public void printData() {
        StringBuilder data = new StringBuilder();
        LinkedListNode<K,V> temp = head;
        while(temp != null) {
            data.append(temp.toString()).append("->");
            temp = temp.next;
        }
        System.out.println(data);
    }

    @Override
    public Object getHeadKey() {
        return (this.head  != null) ? head.key : null;
    }

    @Override
    public Object getTailKey() {
        return (this.tail  != null) ? tail.key : null;
    }

    /**
     * Doubly linked list implementation, to store the most recently used node at the head of the list.
     */
    private static class LinkedListNode<K, V> {
        K key;
        V data;
        LinkedListNode<K, V> next;
        LinkedListNode<K, V> prev;

        public LinkedListNode(K key, V data) {
            this.key = key;
            this.data = data;
        }

        public String toString() {
            return new StringBuilder(6)
                    .append("{").append(key).append("->").append(data).append("}").toString();
        }

    }
}
