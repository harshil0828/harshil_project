package TwoPointersSlidingWindow;

public class _9BinarySubarraysWithSum {

    // Counts subarrays with sum <= goal
    public static int lessThanEqualToK(int[] nums, int goal) {
        if (goal < 0) {
            return 0;
        }

        int l = 0, r = 0;
        int sum = 0;
        int ans = 0;
        int n = nums.length;

        while (r < n) {
            sum += nums[r];

            // Shrink the window if sum exceeds goal
            while (sum > goal) {
                sum -= nums[l];
                l++;
            }

            // Count all valid subarrays ending at r
            ans += (r - l + 1);
            r++;
        }
        return ans;
    }

    // Counts subarrays with sum exactly equal to goal
    public static int numSubarraysWithSum(int[] nums, int goal) {
        return lessThanEqualToK(nums, goal)
                - lessThanEqualToK(nums, goal - 1);
    }

    public static void main(String[] args) {

        int[] nums = {1, 0, 1, 0, 1};
        int goal = 2;

        int result = numSubarraysWithSum(nums, goal);

        System.out.println("Number of subarrays with sum " + goal + " = " + result);
    }
}
