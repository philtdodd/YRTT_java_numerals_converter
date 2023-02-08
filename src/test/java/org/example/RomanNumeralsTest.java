package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RomanNumeralsTest {
    @Test
    public void convert1ToNumeral() {
        RomanNumerals romanNumerals = new RomanNumerals();

        assertEquals("I", romanNumerals.toNumneral(1));
    }

    @Test
    public void convert2ToNumeral() {
        RomanNumerals romanNumerals = new RomanNumerals();

        assertEquals("II", romanNumerals.toNumneral(2));
    }
}
