package com.ark.ds.trees.binarytrees;

import com.ark.ds.queues.IQueue;
import com.ark.ds.queues.QueueUsingSinglyLinkList;

public class BinaryTree<E> implements IBinaryTree<E> {

    private TreeNode root;
    private int size;

    @Override
    public void add(E data) {
        size++; //Increase the node size
        TreeNode node = new TreeNode(data);
        if (root == null) {
            root = node;
            return;
        }
        //If not the first node add it to left or right node.
        addToLeftOrRight(root, node);
    }

    private void addToLeftOrRight(TreeNode root, TreeNode node) {
        //We need to insert using level order, if any left/child null node found
        //then we need to add to that particular node
        //For Level order Queue is the data structure
        IQueue<TreeNode> queue = new QueueUsingSinglyLinkList<>();
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.dequeue();
            if (current.left == null) {
                current.left = node;
                break;
            } else {
                queue.enqueue(current.left);
            }
            if (current.right == null) {
                current.right = node;
                break;
            } else {
                queue.enqueue(current.right);
            }
        }
    }

    @Override
    public String preOrder() {
        StringBuilder sb = new StringBuilder();
        this.preOrder(this.root, sb);
        return sb.toString();
    }

    //Root -> Left -> Right
    private void preOrder(TreeNode node, StringBuilder sb) {
        if (node == null)
            return;
        sb.append(node.data).append("-");
        preOrder(node.left, sb);
        preOrder(node.right, sb);
    }

    @Override
    public String postOrder() {
        StringBuilder sb = new StringBuilder();
        this.postOrder(this.root, sb);
        return sb.toString();
    }

    //Left -> Root -> Right
    private void postOrder(TreeNode node, StringBuilder sb) {
        if (node == null)
            return;
        postOrder(node.left, sb);
        postOrder(node.right, sb);
        sb.append(node.data).append("-");
    }

    @Override
    public String inOrder() {
        StringBuilder sb = new StringBuilder();
        this.inOrder(this.root, sb);
        return sb.toString();
    }

    //Left -> Root -> Right
    private void inOrder(TreeNode node, StringBuilder sb) {
        if (node == null)
            return;
        inOrder(node.left, sb);
        sb.append(node.data).append("-");
        inOrder(node.right, sb);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private final class TreeNode {
        E data;
        TreeNode left;
        TreeNode right;
        public TreeNode(E data) {
            this.data = data;
        }
    }
}
