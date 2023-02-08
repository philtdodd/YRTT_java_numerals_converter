package org.example;

public class RomanNumerals {

    public String toNumneral(int arabic) {
        String numerals = "";

        while (arabic != 0) {
            if (arabic > 1000) {
                numerals += "M";
                arabic -= 1000;
            } else if (arabic > 500) {
                numerals += "D";
                arabic -= 500;
            } else if (arabic > 100) {
                numerals += "C";
                arabic -= 100;
            } else if (arabic > 50) {
                numerals += "L";
                arabic -= 50;
            } else if (arabic > 10) {
                numerals += "X";
                arabic -= 10;
            } else if (arabic > 5) {
                numerals += "V";
                arabic -= 5;
            } else if (arabic > 1) {
                numerals += "I";
                arabic -= 1;
            }
        }
        return "I";
    }
}
