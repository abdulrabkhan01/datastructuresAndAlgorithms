package com.ark.ds.stacks;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * <p> Balance parenthesis using Stack </p>
 *
 * @author AbdulR
 */
public enum BalanceParenthesisProblem {

    INSTANCE;
    //Map to hold relationship between opening and creating brackets.
    private final static Map<Character, Character> BRACKET_MATCHING_MAP = new HashMap<>(3);

    static {
        BRACKET_MATCHING_MAP.put('}', '{');
        BRACKET_MATCHING_MAP.put(')', '(');
        BRACKET_MATCHING_MAP.put(']', '[');
    }

    /**
     * <p> Checks whether parenthesis are balanced in a given string.</p>
     *
     * @param str - String to verify.
     * @return boolean true if parenthesis are balanced; otherwise false.
     */
    public boolean checkBalance(String str) {
        validate(str);
        IStack<Character> stack = new Stack<>(str.length());
        for (int i = 0; i < str.length(); i++) {
            //Push the Opening Bracket to Stack
            Character character = str.charAt(i);
            if (isOpeningBracket(character)) {
                stack.push(character);
            } else if (isClosingBracket(character) && !stack.isEmpty()
                    && openingClosingBracketNotMatched(stack, character)) {
                return false;
            }
        }
        return stack.isEmpty(); //If String is Balance then stack should be empty.
    }

    private void validate(String str) {
        if (str == null || str.trim().isEmpty())
            throw new IllegalArgumentException("Operation not Supported for null/blank Strings");
    }

    //Get the Character after from the Stack and compare if it matches with the closing bracket
    private boolean openingClosingBracketNotMatched(IStack<Character> stack, Character character) {
        //Check if the Opening Bracket that is present at Stack Top matches the opening bracket for the current element
        return notEquals(stack.pop(), getMatchingOpeningBracket(character).get());
    }

    private boolean notEquals(Character openingBracked, Character character) {
        return !openingBracked.equals(character);
    }

    private Optional<Character> getMatchingOpeningBracket(Character character) {
        return Optional.ofNullable(BRACKET_MATCHING_MAP.get(character));
    }

    //Opening brackets are present in the Map Values.
    private boolean isOpeningBracket(Character character) {
        return BRACKET_MATCHING_MAP.values().contains(character);
    }

    //Closing brackets are present in Map keys.
    private boolean isClosingBracket(Character character) {
        return BRACKET_MATCHING_MAP.keySet().contains(character);
    }
}
