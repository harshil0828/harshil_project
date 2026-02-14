package TwoPointersSlidingWindow;

import java.util.HashMap;
import java.util.Map;


/*
You are allowed to replace at most k characters in a substring so that all characters in that substring become the same.
Find the maximum possible length of such a substring.
 */

public class _8LengthofLongestRepeatingCharachterReplacement {

    public static void main(String[] args) {

        _8LengthofLongestRepeatingCharachterReplacement l = new _8LengthofLongestRepeatingCharachterReplacement();
        int len = l.characterReplacement("AABABBA", 2);
        System.out.println("Max len of longest repeating charachter = " + len);

    }

    public int characterReplacement(String s, int k) {
        int n = s.length();
        int maxlen = 0, maxf = 0;
        int i = 0, j = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (j < n) {
            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            maxf = Math.max(maxf, map.get(ch));

            while ((j - i + 1) - maxf > k) {
                char ch2 = s.charAt(i);
                map.put(ch2, map.get(ch2) - 1); //decrement the frequency
                i++;

            }
            // if((j-i+1)+maxf<=k){
            maxlen = Math.max(maxlen, j - i + 1);
            // }

            j++;
        }
        return maxlen;

    }
}
