package TwoPointersSlidingWindow;

import java.util.Arrays;

public class _4LengthOfLongestSubstring {
    public static void main(String[] args) {
        _4LengthOfLongestSubstring l =  new _4LengthOfLongestSubstring();
        int len = l.lengthOfLongestSubstring("abcabcbb");
        System.out.println("Max len of longest substring = " + len);
    }

    public int lengthOfLongestSubstring(String s) {
        int[] hash = new int[256];
        Arrays.fill(hash, -1);

        int left = 0, right = 0, maxLen = 0, currLen = 0;

        while (right < s.length()) {

            if (hash[s.charAt(right)] != -1) {
                // means that character is already present in our hashmap
                if (hash[s.charAt(right)] >= left) {
                    left = hash[s.charAt(right)] + 1;
                }
            }
            currLen = right - left + 1;
            maxLen = Math.max(maxLen, currLen);

            hash[s.charAt(right)] = right;
            right++;
        }
        return maxLen;
    }
}

