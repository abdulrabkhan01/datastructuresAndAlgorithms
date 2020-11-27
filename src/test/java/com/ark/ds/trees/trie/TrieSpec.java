package com.ark.ds.trees.trie;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <p> Spec to test operations on Trie (Prefix Tree) Data structure.</p>
 */
public class TrieSpec {
    @Test
    public void emptyTrieSpec() {
        ITrie iTrie = new Trie();
        assertTrue(iTrie.isEmpty());
    }

    @Test
    public void nonEmptyTrieSpec() {
        ITrie iTrie = new Trie();
        iTrie.addWord("Success");
        assertFalse(iTrie.isEmpty());
    }

    @Test void triesContainsWordSpec1() {
        ITrie iTrie = new Trie();
        iTrie.addWord("Success");
        assertTrue(iTrie.checkValidWord("Success"));
    }

}
