package org.example;

/*
 * Notes on TDD process
 *
 * This was interesting I had the basic way to handle the tests in my mind so started off with 1 and built up from
 * there. I though the whole 3process was going to be more complicated than this, so it was interesting to see how the
 * problem solution was a lot simpler than I expected it to be. I would probably not have found this is I was just
 * designing the code normally using pen and paper to design the pseudocode.
 *
 * Also, during this process I remembered that at UNI we had to develop a C pretty printer and for this I initially
 * developed a test bed and then the code. So have a past example of TDD. My peers used my testbed to test their code.
 */
public class RomanNumerals {

    public String toNumneral(int arabic) {
        String numerals = "";

        while (arabic != 0) {
            if (arabic >= 1000) {
                numerals += "M";
                arabic -= 1000;
            } else if (arabic >= 900) {
                numerals += "CM";
                arabic -= 900;
            } else if (arabic >= 500) {
                numerals += "D";
                arabic -= 500;
            } else if (arabic >= 400) {
                numerals += "CD";
                arabic -= 400;
            } else if (arabic >= 100) {
                numerals += "C";
                arabic -= 100;
            } else if (arabic >= 90) {
                numerals += "XC";
                arabic -= 90;
            } else if (arabic >= 50) {
                numerals += "L";
                arabic -= 50;
            } else if (arabic >= 40) {
                numerals += "XL";
                arabic -= 40;
            } else if (arabic >= 10) {
                numerals += "X";
                arabic -= 10;
            } else if (arabic == 9) {
                numerals += "IX";
                arabic -= 9;
            } else if (arabic >= 5) {
                numerals += "V";
                arabic -= 5;
            } else if (arabic == 4) {
                numerals += "IV";
                arabic -= 4;
            } else if (arabic >= 1) {
                numerals += "I";
                arabic -= 1;
            }
        }
        return numerals;
    }

    /*
     * This is the version of RomanNumerals to int from my YRTT application process. I worked this solution out in my
     * head. Below I am going to try to implement it using TDD and see what the solution is.
     */
    public static int toIntRecursive(String numeral) {
        int retVal = 0;
        String matched = "";

        // Find Highest Value numeral in string
        if (numeral.contains("M")) {
            matched = "M";
            retVal = 1000;
        } else if (numeral.contains("D")) {
            matched = "D";
            retVal = 500;
        } else if (numeral.contains("C")) {
            matched = "C";
            retVal = 100;
        } else if (numeral.contains("L")) {
            matched = "L";
            retVal = 50;
        } else if (numeral.contains("X")) {
            matched = "X";
            retVal = 10;
        } else if (numeral.contains("V")) {
            matched = "V";
            retVal = 5;
        } else if (numeral.contains("I")) {
            matched = "I";
            retVal = 1;
        }

        String[] remainder = numeral.split(matched, 2);

        // Handle anything the the left of the match numeral - the subtract side
        if (remainder[0] != "")
            retVal -= toIntRecursive(remainder[0]);

        // Handle anything the the right of the match numeral - the add side
        if (remainder[1] != "")
            retVal += toIntRecursive(remainder[1]);

        return (retVal);
    }

    public static int toInt(String numeral) {
        int retVal = 0;

        if (numeral.matches("I"))
            retVal += 1;

        return retVal;
    }
}
