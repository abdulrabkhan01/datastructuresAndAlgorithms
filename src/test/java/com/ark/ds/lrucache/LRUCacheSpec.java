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



}
