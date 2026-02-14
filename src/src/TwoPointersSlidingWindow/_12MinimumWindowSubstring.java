package TwoPointersSlidingWindow;

public class _12MinimumWindowSubstring {

    public static String minWindow(String s, String t) {

        int m = s.length();
        int n = t.length();

        // If s is smaller than t, no valid window exists
        if (m < n) return "";

        // Frequency array for characters in t
        int[] freq = new int[128]; // ASCII characters
        for (int i = 0; i < n; i++) {
            freq[t.charAt(i)]++;
        }

        int left = 0, right = 0;
        int count = 0;               // Number of matched characters
        int minLen = Integer.MAX_VALUE;
        int startIndex = -1;

        while (right < m) {

            char rc = s.charAt(right);

            // If character is needed, increase match count
            if (freq[rc] > 0) {
                count++;
            }

            // Consume this character
            freq[rc]--;

            // Try to shrink the window when valid
            while (count == n) {

                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    startIndex = left;
                }

                char lc = s.charAt(left);
                freq[lc]++;

                // If a required character is removed
                if (freq[lc] > 0) {
                    count--;
                }

                left++;
            }

            right++;
        }

        return startIndex == -1 ? "" : s.substring(startIndex, startIndex + minLen);
    }

    // Main method for testing
    public static void main(String[] args) {

        String s = "ADOBECODEBANC";
        String t = "ABC";

        String result = minWindow(s, t);
        System.out.println("Minimum window substring: " + result);
    }
}

