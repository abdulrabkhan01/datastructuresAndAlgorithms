package com.ark.ds.stacks;

import org.junit.Assert;
import org.junit.Test;



public class StacksSpec {


    @Test(expected = ElementNotFoundException.class)
    public void givenEmptyStackPopShouldThrowException() {
        //Given - An Empty Stack
        IStack<String> stack = new Stack<>();
        //When user tries to do the POP operation
        stack.pop();
        //Exception should be encountered
    }

    public void givenOneElementAddedToEmptyStackSizeShouldBeOne() {
        //Given - An Empty Stack
        IStack<String> stack = new Stack<>();
        //When an element added
        stack.add("A");
        //Then its size should be 1
        Assert.assertEquals(1,stack.size());


    }
}
