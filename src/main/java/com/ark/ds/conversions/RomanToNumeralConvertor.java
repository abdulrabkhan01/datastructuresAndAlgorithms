package com.ark.ds.conversions;

import java.util.*;

/**
 * <p> Implementation for Roman to Numeral convertor.</p>
 *
 * @author AbdulR
 * @since 7/Nov/2020
 */
public class RomanToNumeralConvertor {
    private static final Map<Character, Integer> ROMAN_CHARACTER_MAP = new HashMap<>();

    static {
        ROMAN_CHARACTER_MAP.put('I', 1);
        ROMAN_CHARACTER_MAP.put('V', 5);
        ROMAN_CHARACTER_MAP.put('X', 10);
        ROMAN_CHARACTER_MAP.put('L', 50);
        ROMAN_CHARACTER_MAP.put('C', 100);
        ROMAN_CHARACTER_MAP.put('D', 500);
        ROMAN_CHARACTER_MAP.put('M', 1000);
    }

    /**
     * <p> This method convert Roman Value to Numeral.</p>
     * @param romanValue
     * @return
     * @see "https://en.wikipedia.org/wiki/Roman_numerals"
     */
    public Integer convert(String romanValue) {
        char[] chars = romanValue.toCharArray();
        Integer numeralValue = 0;
        for (int i = 0; i < chars.length; i++) {
            if (i + 1 < chars.length) {
                int currentValue = getNumeralValue(chars[i]);
                int nextValue = getNumeralValue(chars[i+1]);
                if (nextValue > currentValue) {
                    numeralValue += nextValue - currentValue;
                    i++;
                } else {
                    numeralValue += getNumeralValue(chars[i]);
                }
            } else {
                numeralValue += getNumeralValue(chars[i]);
            }
        }
        return numeralValue;
    }

    private Integer getNumeralValue(Character character) {
        Integer value = 0;
        Integer temp = ROMAN_CHARACTER_MAP.get(character);
        if (temp != null) {
            value = temp;
        }
        return value;
    }
}
