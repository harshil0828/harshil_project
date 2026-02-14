package TwoPointersSlidingWindow;

import java.util.*;

public class NiceSubarraysWithPrint {

    // Prints and counts subarrays with exactly k odd numbers
    public static int numberOfSubarraysAndPrint(int[] nums, int k) {
        int n = nums.length;
        int count = 0;

        // Prefix sum of odd counts
        int[] prefix = new int[n + 1];
        prefix[0] = 0;

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + (nums[i] % 2);
        }

        // Check all subarrays
        for (int start = 0; start < n; start++) {
            for (int end = start; end < n; end++) {

                int oddCount = prefix[end + 1] - prefix[start];

                if (oddCount == k) {
                    count++;
                    printSubarray(nums, start, end);
                }
            }
        }
        return count;
    }

    private static void printSubarray(int[] nums, int l, int r) {
        System.out.print("[ ");
        for (int i = l; i <= r; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 2, 1, 1};
        int k = 3;

        int result = numberOfSubarraysAndPrint(nums, k);

        System.out.println("Total nice subarrays = " + result);
    }
}
