package com.ark.ds.trees.trie;

import java.util.List;

/**
 * <p> Interface for operations supported by Trie</p>
 */
public interface ITrie {
    void addWord(String word);
    boolean checkValidWord(String word);
    boolean isEmpty();
}
