package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

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

    @Test
    public void convert3ToNumeral() {
        RomanNumerals romanNumerals = new RomanNumerals();

        assertEquals("III", romanNumerals.toNumneral(3));
    }

    @Test
    public void convert4ToNumeral() {
        RomanNumerals romanNumerals = new RomanNumerals();

        assertEquals("IV", romanNumerals.toNumneral(4));
    }

    @Test
    public void convert5ToNumeral() {
        RomanNumerals romanNumerals = new RomanNumerals();

        assertEquals("V", romanNumerals.toNumneral(5));
    }

    @Test
    public void convert6ToNumeral() {
        RomanNumerals romanNumerals = new RomanNumerals();

        assertEquals("VI", romanNumerals.toNumneral(6));
    }

    @Test
    public void convert7ToNumeral() {
        RomanNumerals romanNumerals = new RomanNumerals();

        assertEquals("VII", romanNumerals.toNumneral(7));
    }

    @Test
    public void convert8ToNumeral() {
        RomanNumerals romanNumerals = new RomanNumerals();

        assertEquals("VIII", romanNumerals.toNumneral(8));
    }

    @Test
    public void convert9ToNumeral() {
        RomanNumerals romanNumerals = new RomanNumerals();

        assertEquals("IX", romanNumerals.toNumneral(9));
    }

    @Test
    public void convert10ToNumeral() {
        RomanNumerals romanNumerals = new RomanNumerals();

        assertEquals("X", romanNumerals.toNumneral(10));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data/numerals.csv", numLinesToSkip = 1)
    void toNumeral_ShouldGenerateTheExpectedRomanNumeralCSVFile(
            int input, String expected) {
        RomanNumerals romanNumerals = new RomanNumerals();

        String actualValue = romanNumerals.toNumneral(input);
        assertEquals(expected, actualValue);
    }
    @ParameterizedTest
    @CsvFileSource(resources = "/data/numerals.csv", numLinesToSkip = 1)
    void toNumeral_ShouldGenerateTheExpectedIntegerCSVFile(
            int expected, String input) {
        RomanNumerals romanNumerals = new RomanNumerals();

        int actualValue = romanNumerals.toInt(input);
        assertEquals(expected, actualValue);
    }


}

