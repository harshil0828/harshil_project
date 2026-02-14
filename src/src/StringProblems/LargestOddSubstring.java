package StringProblems;

/*
You are given a numeric string.

You must:

Find a non-empty substring

That substring must represent an odd number

It must be the largest possible value
*/

/*
Why Loop From Right to Left?

Because:

The largest value must keep as many digits as possible

Removing digits from the right side keeps the number large

 */

public class LargestOddSubstring {

    public static String largestOddNumber(String num) {

        // Traverse from right to left
        for (int i = num.length() - 1; i >= 0; i--) {

            // Convert character digit to integer
            int digit = num.charAt(i) - '0';

            // Check if digit is odd
            if ((digit & 1) == 1) {
                // Return substring from start to this index
                return num.substring(0, i + 1);
            }
        }

        // No odd digit found
        return "";
    }

    public static void main(String[] args) {
        String num1 = "35427";
        String num2 = "4208";

        System.out.println(largestOddNumber(num1)); // 35427
        System.out.println(largestOddNumber(num2)); // ""
    }
}

