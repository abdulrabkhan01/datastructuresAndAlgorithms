package com.ark.ds.stacks;

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
}
