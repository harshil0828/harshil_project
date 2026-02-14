package TwoPointersSlidingWindow;

public class _10NiceSubarrays {

    //A nice subarray is a contiguous subarray containing exactly k odd numbers.

    // Counts subarrays with at most 'goal' odd numbers
    public static int helpMe(int[] nums, int goal) {

        if (goal < 0) {
            return 0;
        }

        int l = 0, r = 0;
        int sum = 0;   // number of odd elements in the window
        int cnt = 0;

        while (r < nums.length) {

            // If nums[r] is odd, add 1; if even, add 0
            sum += nums[r] % 2;

            // Shrink window if odd count exceeds goal
            while (sum > goal) {
                if (nums[l] % 2 == 1) {
                    sum--;
                }
                l++;
            }

            // Count all valid subarrays ending at r
            cnt += (r - l + 1);
            r++;
        }

        return cnt;
    }

    // Counts subarrays with exactly k odd numbers
    public static int numberOfSubarrays(int[] nums, int k) {
        return helpMe(nums, k) - helpMe(nums, k - 1);
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 2, 1, 1};
        int k = 3;

        int result = numberOfSubarrays(nums, k);

        System.out.println("Number of nice subarrays = " + result);
    }
}