package org.example;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Notes on TDD process
 *
 * This was interesting I had the basic way to handle the tests in my mind so started off with 1 and built up from
 * there. I though the whole 3process was going to be more complicated than this, so it was interesting to see how the
 * problem solution was a lot simpler than I expected it to be. I would probably not have found this is I was just
 * designing the code normally using pen and paper to design the pseudocode. The If's used initially were refactored
 * an array of records to simplify the code. This would make it easy to extend the roman system further easily.
 *
 * Also, during this process I remembered that at UNI we had to develop a C pretty printer and for this I initially
 * developed a test bed and then the code. So have a past example of TDD. My peers used my testbed to test their code.
 */
public class RomanNumerals {
    private record NumeralConverter(String numeral, int arabic) {
    }

    private final NumeralConverter[] numeralConverterArray = {
            new NumeralConverter("M", 1000),
            new NumeralConverter("CM", 900),
            new NumeralConverter("D", 500),
            new NumeralConverter("CD", 400),
            new NumeralConverter("C", 100),
            new NumeralConverter("XC", 90),
            new NumeralConverter("L", 50),
            new NumeralConverter("XL", 40),
            new NumeralConverter("X", 10),
            new NumeralConverter("IX", 9),
            new NumeralConverter("V", 5),
            new NumeralConverter("IV", 4),
            new NumeralConverter("I", 1)
    };

    public String toNumneral(int arabic) {
        String numerals = "";

        if (arabic == 0)
            throw new IllegalArgumentException("Romans did not use 0.");

        if (arabic < 0)
            throw new IllegalArgumentException("Romans did not use negative numbers.");

        while (arabic != 0) {
            for (NumeralConverter numeralConverter : numeralConverterArray) {
                if (arabic >= numeralConverter.arabic) {
                    numerals += numeralConverter.numeral;
                    arabic -= numeralConverter.arabic;
                    break;
                }
            }
        }
        return numerals;
    }

    private record ArabicConverter(String numeral, int arabic) {
    }

    private final ArabicConverter[] arabicConverterArray = {
            new ArabicConverter("M", 1000),
            new ArabicConverter("D", 500),
            new ArabicConverter("C", 100),
            new ArabicConverter("L", 50),
            new ArabicConverter("X", 10),
            new ArabicConverter("V", 5),
            new ArabicConverter("I", 1)
    };

    /*
     * I initially started the task by trying to create a solution iteratively. This hit issues when I got the the
     * IV side of the conversion so I wrote a recursive solution handling the addition and subtraction sides of the
     * numerals passed in. Also I refactored this to use a record rather than the if statements in my earlier cycles.
     */
    public int toInt(String numerals) {
        int retVal = 0;
        String matched = "";

        // Validate the Roman numerals are valid
        if (numerals == null)
            throw new IllegalArgumentException("Must pass in a String of Roman numerals.");

        if (numerals.matches(""))
            throw new IllegalArgumentException("Must pass in a set of Roman numerals.");

        String numeralsRegex = "^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";
        Pattern numeralsPattern = Pattern.compile(numeralsRegex);
        Matcher matcher = numeralsPattern.matcher(numerals);
        if (!matcher.matches())
            throw new IllegalArgumentException("String is not a valid list of Roman Numerals.");

        // Find Highest Value numerals in string
        for (ArabicConverter arabicConverter : arabicConverterArray) {
            if (numerals.contains(arabicConverter.numeral)) {
                matched = arabicConverter.numeral;
                retVal = arabicConverter.arabic;
                break;
            }
        }

        String[] remainder = numerals.split(matched, 2);

        // Handle anything the the left of the match numerals - the subtraction side
        if (remainder[0] != "")
            retVal -= toInt(remainder[0]);

        // Handle anything the the right of the match numerals - the addition side
        if (remainder[1] != "")
            retVal += toInt(remainder[1]);

        return (retVal);
    }
}
