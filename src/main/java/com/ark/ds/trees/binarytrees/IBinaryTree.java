package com.ark.ds.trees.binarytrees;

/**
 * <p> Interface to define operations on Binary Tree. </p>
 *
 * @param <E>
 * @author AbdulR
 */
public interface IBinaryTree<E> {
    void add(E data);
    String preOrder();
    String postOrder();
    String inOrder();
    int size();
    boolean isEmpty();
}
