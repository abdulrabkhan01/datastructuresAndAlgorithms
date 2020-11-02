package com.ark.ds.stacks;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
/**
 * <p> </p>Spec for TDD implementation for Stack class. </p>
 * @author  Abdul R
 */
public class StacksSpec {

    @Test
    @DisplayName("given Empty Stack Pop Should Throw ElementNotFoundException Exception")
    public void emptyStackSpec() {
        //Given - An Empty Stack
        IStack<String> stack = new Stack<>(1);
        //When user tries to do the POP operation
        assertThrows(ElementNotFoundException.class,()-> {stack.pop();});
        //Exception should be encountered
    }

    @Test
    @DisplayName("given Empty Stack When one element added its size should become one")
    public void emptyStackFirstElementAddSpec() {
        //Given - An Empty Stack
        IStack<String> stack = new Stack<>(1);
        //When an element added
        stack.push("A");
        //Then its size should be 1
        assertEquals(1,stack.size());
    }
}
