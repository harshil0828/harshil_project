package StringProblems;

public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }

        // Take first string as reference
        String first = strs[0];

        for (int i = 0; i < first.length(); i++) {
            char ch = first.charAt(i);

            // Compare this character with same index in all strings
            for (int j = 1; j < strs.length; j++) {
                // If index exceeds length OR mismatch found
                if (i >= strs[j].length() || strs[j].charAt(i) != ch) {
                    return first.substring(0, i);
                }
            }
        }

        // Entire first string is common prefix
        return first;
    }

    public static void main(String[] args) {
        String[] strs1 = {"flower", "flow", "flight"};
        String[] strs2 = {"dog", "racecar", "car"};

        System.out.println(longestCommonPrefix(strs1)); // "fl"
        System.out.println(longestCommonPrefix(strs2)); // ""
    }
}
