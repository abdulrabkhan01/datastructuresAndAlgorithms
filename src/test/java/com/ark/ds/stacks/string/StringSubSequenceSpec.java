package com.ark.ds.stacks.string;

import com.ark.ds.string.StringSubSequence;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <p> Spec to check if a given sub sequence is present in the given string.</p>
 *
 * @author AbdulR
 */
public class StringSubSequenceSpec {
   private final StringSubSequence stringSubSequence = StringSubSequence.INSTANCE;

    @Test
    public void emptyStringSpec() {
        assertThrows(IllegalArgumentException.class, () -> stringSubSequence.checkSubSequence("", "abc"));
    }

    @Test
    public void nullStringSpec() {
        assertThrows(IllegalArgumentException.class, () -> stringSubSequence.checkSubSequence(null, "abc"));
    }

    @Test
    public void emptySubSeqSpec() {
        assertThrows(IllegalArgumentException.class, () -> stringSubSequence.checkSubSequence("abc", ""));
    }

    @Test
    public void nullSubSeqSpec() {
        assertThrows(IllegalArgumentException.class, () -> stringSubSequence.checkSubSequence("abc", null));
    }

    @Test
    public void subSeqGreatherThanStrSpec() {
        assertFalse(stringSubSequence.checkSubSequence("abc", "abcd"));
    }

    @Test
    public void validSubSeqPresentSpec1() {
        assertTrue(stringSubSequence.checkSubSequence("abc", "abc"));
    }

    @Test
    public void validSubSeqPresentSpec2() {
        assertTrue(stringSubSequence.checkSubSequence("xyzabc", "abc"));
    }

    @Test
    public void validSubSeqPresentSpec3() {
        assertTrue(stringSubSequence.checkSubSequence("xabcy", "abc"));
    }

    @Test
    public void validSubSeqPresentSpec4() {
        assertTrue(stringSubSequence.checkSubSequence("aaaaaaaaaaabcaaaaaaaa", "abc"));
    }

    @Test
    public void validSubSeqNotPresentSpec1() {
        assertFalse(stringSubSequence.checkSubSequence("xyzz", "abc"));
    }
}
