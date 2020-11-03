package com.ark.ds.lrucache;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/***
 * <p> Test class for implementing Least Recently Used Cache aka LRU Cache.
 * Based on link - https://en.wikipedia.org/wiki/Cache_replacement_policies#Least_recently_used_(LRU) </p>
 * @author AbdulR
 */
public class LRUCacheSpec {

    @Test
    public void zeroSizeMapCreationSpec() {
        assertThrows(IllegalArgumentException.class ,() -> {new LRUCache<>(0);});
    }

    @Test
    public void negativeSizeMapCreationSpec() {
        assertThrows(IllegalArgumentException.class ,() -> {new LRUCache<>(-1);});
    }

    @Test
    public void emptyMapSizeShouldReturnZero() {
        ILRUCache<String, Integer> lruCache = new LRUCache<>(1);
        assertTrue(lruCache.size()==0);
    }

    @Test
    public void emptyMapIsEmptyShouldReturnTrue() {
        ILRUCache<String, Integer> lruCache = new LRUCache<>(1);
        assertTrue(lruCache.isEmpty());
    }

    @Test
    public void nonEmptyMapShouldReturnActualSize() {
        ILRUCache<String, Integer> lruCache = new LRUCache<>(1);
        lruCache.put("Key",1);
        assertTrue(lruCache.size()==1);
    }

    @Test
    public void whenKeyNotExistsContainsKeyShouldReturnFalse() {
        ILRUCache<String, Integer> lruCache = new LRUCache<>(1);
        assertFalse(lruCache.containsKey("ABC"));
    }
    @Test
    public void whenKeyAddedContainsKeyShouldReturnTrue() {
        ILRUCache<String, Integer> lruCache = new LRUCache<>(1);
        lruCache.put("K1",1);
        assertTrue(lruCache.containsKey("K1"));
    }

    @Test
    public void maxCapacitySpec() {
        final int maxCapacity = 10;
        ILRUCache<String, Integer> lruCache = new LRUCache<>(maxCapacity);
        for(int i=0; i< maxCapacity+1;i++) {
            lruCache.put("K"+i,i);
        }
        assertTrue(lruCache.size()==maxCapacity);
    }

    @Test
    public void leastRecentlyUsedItemEvictedSpec1() {
        final int maxCapacity = 2;
        ILRUCache<String, Integer> lruCache = new LRUCache<>(maxCapacity);
        lruCache.put("A",1);
        lruCache.printData();
        lruCache.put("B",2);
        lruCache.printData();
        lruCache.put("C",3);
        lruCache.printData();
        assertFalse(lruCache.containsKey("A"));
        assertTrue(lruCache.containsKey("B"));
        assertTrue(lruCache.containsKey("C"));
    }

    @Test
    public void leastRecentlyUsedItemEvictedSpec2() {
        final int maxCapacity = 3;
        ILRUCache<String, Integer> lruCache = new LRUCache<>(maxCapacity);
        lruCache.put("A",1);
        lruCache.printData();
        lruCache.put("B",2);
        lruCache.printData();
        lruCache.put("C",3);
        lruCache.printData();
        lruCache.put("D",4);
        lruCache.printData();
        assertFalse(lruCache.containsKey("A"));
        assertTrue(lruCache.containsKey("B"));
        assertTrue(lruCache.containsKey("C"));
        assertTrue(lruCache.containsKey("D"));
    }

    @Test
    public void leastRecentlyUsedItemEvictedSpec3() {
        final int maxCapacity = 2;
        ILRUCache<String, Integer> lruCache = new LRUCache<>(maxCapacity);
        lruCache.put("A",1);
        lruCache.printData();
        lruCache.put("B",2);
        lruCache.printData();
        lruCache.put("A",3);
        lruCache.printData();
        assertTrue(lruCache.containsKey("A"));
        lruCache.printData();
        assertTrue(lruCache.containsKey("B"));
        lruCache.printData();
        assertTrue(lruCache.get("A")==3);
        lruCache.printData();
    }

    @Test
    public void leastRecentlyUsedItemEvictedSpec4() {
        final int maxCapacity = 2;
        ILRUCache<String, Integer> lruCache = new LRUCache<>(maxCapacity);
        lruCache.put("A",1);
        lruCache.printData();
        lruCache.put("A",2);
        lruCache.printData();
        lruCache.put("A",3);
        lruCache.printData();
        assertTrue(lruCache.containsKey("A"));
        lruCache.printData();
        assertTrue(lruCache.get("A")==3);
        assertTrue(lruCache.size()==1);
    }

    @Test
    public void leastRecentlyUsedItemEvictedSpec5() {
        final int maxCapacity = 2;
        ILRUCache<String, Integer> lruCache = new LRUCache<>(maxCapacity);
        lruCache.put("A",1);
        lruCache.printData();
        lruCache.put("B",2);
        lruCache.printData();
        lruCache.put("A",3);
        lruCache.printData();
        lruCache.put("C",4);
        lruCache.printData();
        assertTrue(lruCache.containsKey("A"));
        assertTrue(lruCache.get("A")==3);
        lruCache.printData();
        assertTrue(lruCache.containsKey("C"));
        assertFalse(lruCache.containsKey("B"));
    }

    @Test
    public void leastRecentlyUsedHeadTailSpec1() {
        final int maxCapacity = 3;
        ILRUCache<String, Integer> lruCache = new LRUCache<>(maxCapacity);
        lruCache.put("A",1);
        lruCache.printData();
        lruCache.put("B",2);
        lruCache.printData();
        lruCache.put("C",3);
        lruCache.printData();
        lruCache.put("B",4);
        lruCache.printData();
        lruCache.put("D",5);
        lruCache.printData();
        assertTrue(lruCache.containsKey("B"));
        assertTrue(lruCache.containsKey("C"));
        assertTrue(lruCache.containsKey("D"));
        assertTrue(lruCache.getHeadKey()=="D");
        assertTrue(lruCache.getTailKey()=="C");
    }

    @Test
    public void leastRecentlyUsedHeadTailSpec2() {
        final int maxCapacity = 3;
        ILRUCache<String, Integer> lruCache = new LRUCache<>(maxCapacity);
        lruCache.put("A",1);
        lruCache.printData();
        lruCache.put("B",2);
        lruCache.printData();
        lruCache.put("C",3);
        lruCache.printData();
        lruCache.put("D",4);
        lruCache.printData();
        lruCache.put("E",5);
        lruCache.printData();
        lruCache.put("F",5);
        lruCache.printData();
        assertTrue(lruCache.containsKey("F"));
        assertTrue(lruCache.containsKey("E"));
        assertTrue(lruCache.containsKey("D"));
        assertTrue(lruCache.getHeadKey()=="F");
        assertTrue(lruCache.getTailKey()=="D");
    }
}
