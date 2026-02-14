package TwoPointersSlidingWindow;


//Code to find longest subarray where sum is less than k

public class _2LongestSubarray {

    public static void main(String[] args) {
        int[] numbers = {2, 5, 1, 7, 10};
        int k = 14;
        int sum = 0;
        int l = 0;
        int r = 0;
        int maxlen = 0;

        while (r < numbers.length) {
            sum = sum + numbers[r];

            while (sum > k) {
                sum -= numbers[l];
                l++;
            }

            if (sum <= k) {
                maxlen = Math.max(maxlen, r - l + 1);
            }
            r++;
        }

        System.out.println("Max length of subarray = " + maxlen);
    }
}