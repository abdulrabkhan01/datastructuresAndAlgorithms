package com.ark.ds.stacks;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <p> Spec to verify balance parenthesis problem.</p>
 *
 * @author AbdulR
 */
public class BalanceParenthesisSpec {
    BalanceParenthesisProblem balanceParenthesis = BalanceParenthesisProblem.INSTANCE;

    @Test
    public void testEmptyString() {
        assertThrows(IllegalArgumentException.class, () -> balanceParenthesis.checkBalance(""));
    }

    @Test
    public void testNullString() {
        assertThrows(IllegalArgumentException.class, () -> balanceParenthesis.checkBalance(null));
    }

    @Test
    public void testAllSpacesString() {
        assertThrows(IllegalArgumentException.class, () -> balanceParenthesis.checkBalance("  "));
    }

    @Test
    public void testUnbalcedString1() {
        assertFalse(balanceParenthesis.checkBalance("("));
    }

    @Test
    public void testUnbalcedString2() {
        assertFalse(balanceParenthesis.checkBalance("({"));
    }

    @Test
    public void testUnbalancedString3() {
        assertFalse(balanceParenthesis.checkBalance("({)"));
    }

    @Test
    public void testUnbalancedString4() {
        assertFalse(balanceParenthesis.checkBalance(")("));
    }

    @Test
    public void testUnbalancedString5() {
        assertFalse(balanceParenthesis.checkBalance(")({}"));
    }

    @Test
    public void testUnbalancedString6() {
        assertFalse(balanceParenthesis.checkBalance("()({}"));
    }

    @Test
    public void testBalancedString1() {
        assertTrue(balanceParenthesis.checkBalance("()"));
    }

    @Test
    public void testBalancedString2() {
        assertTrue(balanceParenthesis.checkBalance("()"));
    }

    @Test
    public void testBalancedString3() {
        assertTrue(balanceParenthesis.checkBalance("{}"));
    }

    @Test
    public void testBalancedString4() {
        assertTrue(balanceParenthesis.checkBalance("[]"));
    }

    @Test
    public void testBalancedString5() {
        assertTrue(balanceParenthesis.checkBalance("{ (abc) }"));
    }

    @Test
    public void testBalancedString6() {
        assertTrue(balanceParenthesis.checkBalance("{ () [] }"));
    }


}
