package com.ark.ds.trees.trie;

import java.util.*;

/**
 * <p> Prefix Tree/ Trie implementation. </p>
 */
public class Trie implements ITrie {
    private int wordCount;
    private final TrieNode root = new TrieNode();

    public void addWord(String str) {
        wordCount++;
        Map<Character, TrieNode> childTrieNodes = root.childTrieNodes;
        char[] chars = str.toCharArray();
        int count = 0;
        for (Character character : chars) {
            TrieNode temp = childTrieNodes.get(character);
            if (temp == null) {
                temp = new TrieNode();
                temp.data = character;
                childTrieNodes.put(character, temp);
            }
            childTrieNodes = temp.childTrieNodes;
            if (++count == chars.length) {
                temp.wordFlag = true;
            }
        }
    }

    public boolean checkValidWord(String str) {
        TrieNode node = findNode(str);
        return node != null && node.wordFlag;
    }

    @Override
    public boolean isEmpty() {
        return wordCount == 0;
    }

    private TrieNode findNode(String str) {
        Map<Character, TrieNode> childTrieNodes = root.childTrieNodes;
        char[] chars = str.toCharArray();
        TrieNode node = null;
        for (Character character : chars) {
            node = childTrieNodes.get(character);
            if (node == null) {
                break;
            }
            //Node is found
            childTrieNodes = node.childTrieNodes;
        }
        return node;
    }


    private static class TrieNode {
        Character data;
        final Map<Character, TrieNode> childTrieNodes = new HashMap<>();
        boolean wordFlag; //Indicates if it forms the full word.
    }

}
