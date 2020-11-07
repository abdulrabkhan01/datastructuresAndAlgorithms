package com.ark.ds.conversions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 * <p> Roman to Numeral conversion using TDD. </p>
 * @author AbdulR
 * @since 7-Nov-2020
 */
public class RomanToNumeralConversionSpec {

    @Test
    public void romanToNumeralSpec1() {
        RomanToNumeralConvertor romanToNumeralConvertor = new RomanToNumeralConvertor();
        long numeralValue = romanToNumeralConvertor.convert("I");
        assertEquals(1,numeralValue);
    }

    @Test
    public void romanToNumeralSpec2() {
        RomanToNumeralConvertor romanToNumeralConvertor = new RomanToNumeralConvertor();
        long numeralValue = romanToNumeralConvertor.convert("IV");
        assertEquals(4,numeralValue);
    }

    @Test
    public void romanToNumeralSpec3() {
        RomanToNumeralConvertor romanToNumeralConvertor = new RomanToNumeralConvertor();
        long numeralValue = romanToNumeralConvertor.convert("X");
        assertEquals(10,numeralValue);
    }

    @Test
    public void romanToNumeralSpec4() {
        RomanToNumeralConvertor romanToNumeralConvertor = new RomanToNumeralConvertor();
        long numeralValue = romanToNumeralConvertor.convert("IX");
        assertEquals(9,numeralValue);
    }
    @Test
    public void romanToNumeralSpec5() {
        RomanToNumeralConvertor romanToNumeralConvertor = new RomanToNumeralConvertor();
        long numeralValue = romanToNumeralConvertor.convert("XL");
        assertEquals(40,numeralValue);
    }
    @Test
    public void romanToNumeralSpec6() {
        RomanToNumeralConvertor romanToNumeralConvertor = new RomanToNumeralConvertor();
        long numeralValue = romanToNumeralConvertor.convert("XC");
        assertEquals(90,numeralValue);
    }
    @Test
    public void romanToNumeralSpec7() {
        RomanToNumeralConvertor romanToNumeralConvertor = new RomanToNumeralConvertor();
        long numeralValue = romanToNumeralConvertor.convert("CD");
        assertEquals(400,numeralValue);
    }
    @Test
    public void romanToNumeralSpec8() {
        RomanToNumeralConvertor romanToNumeralConvertor = new RomanToNumeralConvertor();
        long numeralValue = romanToNumeralConvertor.convert("CM");
        assertEquals(900,numeralValue);
    }

}
