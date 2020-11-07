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

}
