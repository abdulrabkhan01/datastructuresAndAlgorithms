package com.ark.ds.stacks;

/**
 * Interface for stack implementation
 * @param <E>
 * @author AbdulRabKhan
 */
public interface IStack<E> {
    /**
     * <p> Pushes the element at top of the stack.</p>
     * @param e - E
     */
    void push(E e);

    /**
     * <p> </p>Pops the element [E} from the top of the stack. </p>
     * @return E - the element from top
     */
    E pop();

    /**
     *<p> Returns the total element count for the stack.</p>
     * @return size as int.
     */
    int size();

    /**
     * <p> Checks if stack is empty.</p>
     * @return boolean
     */
    boolean isEmpty();

}
