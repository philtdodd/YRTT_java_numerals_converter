package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

public class RomanNumeralsTest {
    @Test
    public void convert0ToNumeral() {
        RomanNumerals romanNumerals = new RomanNumerals();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            romanNumerals.toNumneral(0);
        });

        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.matches("Romans did not use 0."));
    }

    @Test
    public void convertNegativeToNumeral() {
        RomanNumerals romanNumerals = new RomanNumerals();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            romanNumerals.toNumneral(-1);
        });

        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.matches("Romans did not use negative numbers."));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data/numerals.csv", numLinesToSkip = 1)
    void toNumeral_ShouldGenerateTheExpectedRomanNumeralCSVFile(
            int input, String expected) {
        RomanNumerals romanNumerals = new RomanNumerals();

        String actualValue = romanNumerals.toNumneral(input);
        assertEquals(expected, actualValue);
    }

    @Test
    public void toIntPassInNull() {
        RomanNumerals romanNumerals = new RomanNumerals();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            romanNumerals.toInt(null);
        });

        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.matches("Must pass in a String of Roman numerals."));
    }

    @Test
    public void toIntPassInEmptyString() {
        RomanNumerals romanNumerals = new RomanNumerals();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            romanNumerals.toInt("");
        });

        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.matches("Must pass in a set of Roman numerals."));
    }

    @Test
    public void toIntPassInInvalid() {
        RomanNumerals romanNumerals = new RomanNumerals();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            romanNumerals.toInt("ABCD");
        });

        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.matches("String is not a valid list of Roman Numerals."));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data/numerals.csv", numLinesToSkip = 1)
    void toInt_ShouldGenerateTheExpectedIntegerCSVFile(
            int expected, String input) {
        RomanNumerals romanNumerals = new RomanNumerals();

        int actualValue = romanNumerals.toInt(input);
        assertEquals(expected, actualValue);
    }


}

