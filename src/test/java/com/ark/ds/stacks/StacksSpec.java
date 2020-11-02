package com.ark.ds.stacks;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 * <p> </p>Spec for TDD implementation for Stack class. </p>
 * @author  Abdul R
 */
public class StacksSpec {

    @Test
    @DisplayName("Given Empty Stack Pop Should Throw ElementNotFoundException Exception")
    public void emptyStackSpec() {
        //Given - An Empty Stack
        IStack<String> stack = new Stack<>(1);
        //When user tries to do the POP operation
        assertThrows(ElementNotFoundException.class,()-> {stack.pop();});
        //Exception should be encountered
    }

    @Test
    @DisplayName("Given Empty Stack When one element added its size should become one")
    public void emptyStackFirstElementAddSpec() {
        //Given - An Empty Stack
        IStack<String> stack = new Stack<>(1);
        //When an element added
        stack.push("A");
        //Then its size should be 1
        assertEquals(1,stack.size());
    }

    @Test
    @DisplayName("Given  Stack with no element When isEmpty method is called  its should return boolean true")
    public void isEmptySpecWhenStackIsEmpty() {
        //Given - An Empty Stack
        IStack<String> stack = new Stack<>(1);
        //When no elements present
        //Then isEmpty Method should return true
        assertTrue(stack.isEmpty());
    }

    @Test
    @DisplayName("Given  Stack with no element once element added and isEmpty() method called,  its should return boolean false")
    public void isEmptySpecWhenStackIsNotEmpty() {
        //Given - An Empty Stack
        IStack<String> stack = new Stack<>(1);
        //When an element added
        stack.push("A");
        //Then isEmpty Method should return false
        assertFalse(stack.isEmpty());
    }

    @Test
    @DisplayName("Given  Stack with no element When isEmpty method is called  its should return size as 0")
    public void sizeSpecWhenStackIsEmpty() {
        //Given - An Empty Stack
        IStack<String> stack = new Stack<>(1);
        //When no elements present
        //Then isEmpty Method should return true
        assertTrue(stack.size()==0);
    }

    @Test
    @DisplayName("Given  Stack with no element once element added and isEmpty() method called,  its should return size as 1")
    public void sizeSpecWhenStackIsNotEmpty() {
        //Given - An Empty Stack
        IStack<String> stack = new Stack<>(1);
        //When an element added
        stack.push("A");
        //Then isEmpty Method should return false
        assertTrue(stack.size()==1);
    }

    @Test
    @DisplayName("Given  Stack with one element When pop operation is called  its size should become zero")
    public void stackWithOneElementPushAndPopSpec() {
        //Given - An Empty Stack
        IStack<String> stack = new Stack<>(1);
        //When an element added
        stack.push("A");
        //Then its size should be 1
        assertEquals(1,stack.size());
        stack.pop();
        assertTrue(stack.isEmpty());
    }


}
