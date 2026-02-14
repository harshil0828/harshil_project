package TwoPointersSlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class _11SubarraysWithKDistinct {

    // Counts subarrays with at most k distinct integers
    public static int helper(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }

        int left = 0, right = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        while (right < nums.length) {

            // Add current element to the map
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            // Shrink window if distinct count exceeds k
            while (map.size() > k) {
                map.put(nums[left], map.get(nums[left]) - 1);

                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }

            // Count all valid subarrays ending at 'right'
            count += (right - left + 1);
            right++;
        }

        return count;
    }

    // Counts subarrays with exactly k distinct integers
    public static int subarraysWithKDistinct(int[] nums, int k) {
        return helper(nums, k) - helper(nums, k - 1);
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 1, 2, 3};
        int k = 2;

        int result = subarraysWithKDistinct(nums, k);

        System.out.println("Subarrays with exactly " + k + " distinct integers = " + result);
    }
}

