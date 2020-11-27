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

    @Test void triesContainsWordSpec2() {
        ITrie iTrie = new Trie();
        iTrie.addWord("Practice");
        iTrie.addWord("Makes");
        iTrie.addWord("Perfect");
        iTrie.addWord("AND");
        iTrie.addWord("NOTHING");
        iTrie.addWord("IS");
        iTrie.addWord("IMPOSSIBLE");
        assertTrue(iTrie.checkValidWord("Practice"));
    }

    @Test void triesContainsWordSpec3() {
        ITrie iTrie = new Trie();
        iTrie.addWord("Practice");
        iTrie.addWord("Makes");
        iTrie.addWord("Perfect");
        iTrie.addWord("AND");
        iTrie.addWord("NOTHING");
        iTrie.addWord("IS");
        iTrie.addWord("IMPOSSIBLE");
        assertTrue(iTrie.checkValidWord("Makes"));
    }

    @Test void triesDoesNotContainsWordSpec1() {
        ITrie iTrie = new Trie();
        iTrie.addWord("Practice");
        iTrie.addWord("Makes");
        iTrie.addWord("Perfect");
        iTrie.addWord("AND");
        iTrie.addWord("NOTHING");
        iTrie.addWord("IS");
        iTrie.addWord("IMPOSSIBLE");
        assertFalse(iTrie.checkValidWord("Practices"));
    }
}
