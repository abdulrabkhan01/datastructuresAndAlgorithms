package com.ark.ds.trees.binarytrees.segementtrees;

import java.util.Arrays;

public class SegmentTree {
    private final int[] segments;
    private final int[] origArray;

    public SegmentTree(int[] origArray) {
        int origArrayLength = origArray.length;
        int segmentTreeLength = getSegmentTreeLen(origArrayLength);
        segments = new int[segmentTreeLength];
        this.origArray=origArray;
        buildTree(origArray);
    }

    private void buildTree(int[] origArray) {
        buildTreeRecursive(origArray, 0, origArray.length - 1, 0); //Start with 0th index as root
    }

    private int buildTreeRecursive(int[] origArray, int low, int high, int current) {

        if (low == high) {
            this.segments[current] = origArray[low];
            return this.segments[current];
        }
        //otherwise
        int mid = low + (high - low) / 2;
        segments[current] = buildTreeRecursive(origArray, low, mid, current * 2 + 1) +
                buildTreeRecursive(origArray, mid + 1, high, current * 2 + 2);
        return segments[current];
    }

    public int sumQuery(int low, int high, int qlow, int qhigh) {
        return sumQueryRecursive(low, high, qlow, qhigh, 0);
    }

    private int sumQueryRecursive(int low, int high, int qlow, int qhigh, int current) {
        //Check full match
        if (qlow <= low && qhigh >= high) {
            return segments[current];
        }

        //No Match
        if (high < qlow || low > qhigh) {
            return 0;
        }
        //Else recursively search in left or right sub tress
        int mid = low + (high - low) / 2;
        return sumQueryRecursive(low, mid, qlow, qhigh, current * 2 + 1)
             + sumQueryRecursive(mid + 1, high, qlow, qhigh, current * 2 + 2);
    }

    private int getSegmentTreeLen(int origArrayLength) {
        if (isPowerOf2(origArrayLength)) {
            return origArrayLength * 2 - 1;
        } else {
            return calculateLength(origArrayLength);
        }
    }


    private static boolean isPowerOf2(int n) {
        return (n != 0) && ((n & (n - 1)) == 0);
    }

    private static int calculateLength(int i) {
        int height = (int) Math.ceil((Math.log(i) / Math.log(2)));
        return 2 * (int) (Math.pow(2, height));
    }

    public void update(int index, int value) {
        updateRecursive(0, origArray.length-1, index, value, 0 );
    }

    private void updateRecursive(int low, int high, int index, int value, int current) {
        if(low==high) {
            //Leaf Node
            segments[current] = value;
            origArray[index] = value;
            return;
        }
        int mid = low + (high - low)/2;

        if (index >=low && index < mid) {
            //left subtree
            updateRecursive(low,mid, index,value, current* 2 +1);
        } else {
            //right subtree
            updateRecursive(mid+1, high, index, value , current * 2 + 2);
        }
        //Recalculate the sum
        segments[current] = segments[current*2+1] + segments[current*2+2];
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(segments).forEach(s -> sb.append(" ").append(s));
        System.out.println(sb);

    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7, 9, 11};
        Arrays.stream(a).forEach(System.out::println);
        SegmentTree segmentTree = new SegmentTree(a);
        segmentTree.print();
        System.out.println("sum Query 0 -> 0 " + segmentTree.sumQuery(0, a.length - 1, 0, 0));
        System.out.println("sum Query 0 -> 1 " + segmentTree.sumQuery(0, a.length - 1, 0, 1));
        System.out.println("sum Query 0 -> 2 " + segmentTree.sumQuery(0, a.length - 1, 0, 2));
        System.out.println("sum Query 0 -> 3 " + segmentTree.sumQuery(0, a.length - 1, 0, 3));
        System.out.println("sum Query 0 -> 4 " + segmentTree.sumQuery(0, a.length - 1, 0, 4));
        System.out.println("sum Query 0 -> 5 " + segmentTree.sumQuery(0, a.length - 1, 0, 5));
        System.out.println("sum Query 1 -> 3 " + segmentTree.sumQuery(0, a.length - 1, 1, 3));
        System.out.println("sum Query 2 -> 5 " + segmentTree.sumQuery(0, a.length - 1, 2, 5));
        segmentTree.print();
        segmentTree.update(5, 12);
        segmentTree.print();
    }
}

