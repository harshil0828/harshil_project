package StringProblems;

/*
“Remove Outermost Parentheses”
Problem statement (simple words):

You are given a valid parentheses string made of multiple primitive parentheses groups.

A primitive parentheses string:

Is non-empty

Is valid

Cannot be split into two non-empty valid parentheses strings

👉 For each primitive, remove its outermost parentheses.

*/

public class RemoveOuterParentheses {

    public static String removeOuterParentheses(String s) {

        StringBuilder result = new StringBuilder();
        int depth = 0;

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if (currentChar == '(') {
                depth++;
                if (depth > 1) {
                    result.append(currentChar);
                }
            } else { // ')'
                depth--;
                if (depth > 0) {
                    result.append(currentChar);
                }
            }
        }

        return result.toString();
    }

    // ✅ main method added
    public static void main(String[] args) {
        String s = "(()())(())(()(()))";
        String output = removeOuterParentheses(s);
        System.out.println("Output: " + output);
    }
}

