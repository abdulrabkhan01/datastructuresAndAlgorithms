package com.ark.ds.trees.binarytrees;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <p> Binary Tree Spec.</p>
 *
 * @author AbdulR
 */
public class BinaryTreeSpec {

    @Test
    public void testEmptyTree() {
        IBinaryTree<String> binaryTree = new BinaryTree<>();
        assertTrue(binaryTree.isEmpty());
    }

    @Test
    public void testTreeWithOneNode() {
        IBinaryTree<String> binaryTree = new BinaryTree<>();
        String data = "abc";
        binaryTree.add(data);
        assertEquals(binaryTree.size(), 1);
        assertTrue(binaryTree.postOrder().contains(data));
        assertTrue(binaryTree.preOrder().contains(data));
        assertTrue(binaryTree.inOrder().contains(data));
    }

    @Test
    public void testTreeWithTwoNodes() {
        IBinaryTree<String> binaryTree = new BinaryTree<>();
        String data1 = "A"; //Should be added as Root
        String data2 = "B"; //Should be added as Left Child of Root
        binaryTree.add(data1);
        binaryTree.add(data2);
        assertEquals(binaryTree.size(), 2);
        assertEquals("A-B-", binaryTree.preOrder()); //Root(A)-> Left(B)-> Right("")
        assertEquals("B-A-", binaryTree.inOrder()); //Left(B)-> Root(A) -> Right("")
        assertEquals("B-A-", binaryTree.postOrder());//Left(B)-> Right("") -> Root(A)
    }

    @Test
    public void testTreeWithThreeNodes() {
        IBinaryTree<String> binaryTree = new BinaryTree<>();
        String data1 = "A"; //Should be added as Root
        String data2 = "B"; //Should be added as Left Child of Root
        String data3 = "C"; //Should be added as Right Child of Root
        binaryTree.add(data1);
        binaryTree.add(data2);
        binaryTree.add(data3);
        assertEquals(binaryTree.size(), 3);
        assertEquals("A-B-C-", binaryTree.preOrder()); //Root(A)-> Left(B)-> Right(C)
        assertEquals("B-A-C-", binaryTree.inOrder()); //Left(B)-> Root(A) -> Right(C)
        assertEquals("B-C-A-", binaryTree.postOrder());//Left(B)-> Right(C) -> Root(A)
    }

    @Test
    public void testTreeWithThreeFourNodes() {
        IBinaryTree<String> binaryTree = new BinaryTree<>();
        String data1 = "A"; //Should be added as Root
        String data2 = "B"; //Should be added as Left Child of Root
        String data3 = "C"; //Should be added as Right Child of Root
        String data4 = "D"; //Should be added as Left Child of "B"
        binaryTree.add(data1);
        binaryTree.add(data2);
        binaryTree.add(data3);
        binaryTree.add(data4);
        assertEquals(binaryTree.size(), 4);
        assertEquals("A-B-D-C-", binaryTree.preOrder());
        assertEquals("D-B-A-C-", binaryTree.inOrder());
        assertEquals("D-B-C-A-", binaryTree.postOrder());
    }

    @Test
    public void testTreeWithFiveNodes() {
        IBinaryTree<String> binaryTree = new BinaryTree<>();
        String data1 = "A"; //Should be added as Root
        String data2 = "B"; //Should be added as Left Child of Root
        String data3 = "C"; //Should be added as Right Child of Root
        String data4 = "D"; //Should be added as Left Child of "B"
        String data5 = "E"; //Should be added as Right Child of "B"
        binaryTree.add(data1);
        binaryTree.add(data2);
        binaryTree.add(data3);
        binaryTree.add(data4);
        binaryTree.add(data5);
        assertEquals("D-B-E-A-C-", binaryTree.inOrder());
        assertEquals("D-E-B-C-A-", binaryTree.postOrder());
    }
}
