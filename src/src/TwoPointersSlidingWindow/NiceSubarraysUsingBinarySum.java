package TwoPointersSlidingWindow;

public class NiceSubarraysUsingBinarySum {

    // Counts subarrays with sum <= goal (binary array)
    private static int lessThanEqualToK(int[] nums, int goal) {
        if (goal < 0) {
            return 0;
        }

        int l = 0, sum = 0, count = 0;

        for (int r = 0; r < nums.length; r++) {
            sum += nums[r];

            while (sum > goal) {
                sum -= nums[l];
                l++;
            }

            count += (r - l + 1);
        }
        return count;
    }

    // Counts subarrays with exactly k odd numbers
    public static int numberOfSubarrays(int[] nums, int k) {

        // Convert to binary array: odd -> 1, even -> 0
        int[] binary = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            binary[i] = nums[i] % 2;
        }

        return lessThanEqualToK(binary, k)
                - lessThanEqualToK(binary, k - 1);
    }

    public static void main(String[] args) {

        //int[] nums = {1, 1, 2, 1, 1};
        int[] nums = {1, 5, 2, 1, 1};
        int k = 3;

        int result = numberOfSubarrays(nums, k);

        System.out.println("Number of nice subarrays = " + result);
    }
}
