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
     *
     * Note that the use of literal values rather than const/enum wass used as these will not change and use of such
     * types would just mke the code bloated and harder to read.
     */
    public static int toInt(String numeral) {
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
            retVal -= toInt(remainder[0]);

        // Handle anything the the right of the match numeral - the add side
        if (remainder[1] != "")
            retVal += toInt(remainder[1]);

        return (retVal);
    }

    /**************************************************************************************************************
     * This commented out code was the point where it was obvious that recursion was the best way forward.
     * Left in for visibility, it would be removed in the real code.
     **************************************************************************************************************

    // Would have put in the values, but as they don't change this would have bloated the code, and made the code
    // difficult to read. Therefore, I stuck to using the literal values in the code.
    enum Numeral {
        NOTSET,
        I,
        V,
        X,
        L,
        C,
        D,
        M
    }

    private static int toIntFailed(String numeral) {
        int positive = 0;
        int negative = 0;
        int current = 0;
        Numeral lastNumeral = Numeral.NOTSET;
        while (numeral.length() != 0) {
            if (numeral.substring(0, 1).matches("X")) {
                numeral = numeral.substring(1);
                if (retVal != 0)
                    retVal = 10 - retVal;
                else
                    retVal = 10;
                lastNumeral = Numeral.X;
            } else if (numeral.substring(0, 1).matches("V")) {
                numeral = numeral.substring(1);
                if (lastNumeral == Numeral.I)
                    current = 4;
                else if (lastNumeral.ordinal() > Numeral.V.ordinal()) { // not I
                    negative += 5;
                    current = 0;
                } else {
                    positive += 5;
                }
                lastNumeral = Numeral.V;
            } else if (numeral.substring(0, 1).matches("I")) {
                numeral = numeral.substring(1);
                current += 1;
                if (lastNumeral) { // not I
                    positive += current;
                    current = 0;
                }
                lastNumeral = Numeral.I;
            }
        }
        return positive + current - negative;
    }
    ***************************************************************************************************************/
}
