package TwoPointersSlidingWindow;

import java.util.Arrays;

public class _7SubstringContainingAllThreeCharachters {

    //For Brute force approach refer to notes

    /*
    'b' - 'a' = 98 - 97 = 1
    This converts a character into an array index.
    We store the current index r as the last position where this character appeared.

    This works ONLY IF:
    String contains lowercase letters 'a' to 'z'
    If string has:
    Uppercase
    Digits
    Unicode
    👉 Use HashMap<Character, Integer> instead.

    ✔ Works only because:
    String contains only 'a', 'b', 'c'
    If more characters → different approach needed.

     */

    public static void main(String[] args) {

        _7SubstringContainingAllThreeCharachters l = new _7SubstringContainingAllThreeCharachters();
        int len = l.numberOfSubstrings("bbacbc");
        System.out.println("Number of sunstrings = " + len);

    }

    public int numberOfSubstrings(String s) {
        int len = 0;
        int r = 0;
        int[] arr = new int[3];
        Arrays.fill(arr, -1);
        while (r < s.length()) {
            arr[s.charAt(r) - 'a'] = r;
            if (arr[0] != -1 && arr[1] != -1 && arr[2] != -1) {
                len = len + 1 + Math.min(arr[0], Math.min(arr[1], arr[2]));

            }
            r++;
        }
        return len;
    }


}
