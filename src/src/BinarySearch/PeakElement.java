package BinarySearch;

/*
Peak element:
An element that is strictly greater than its neighbors
(nums[i] > nums[i-1] and nums[i] > nums[i+1])
*/

public class PeakElement {

    public static int findPeakElement(int[] nums) {

        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] < nums[mid + 1]) {
                // Peak lies on the right side
                low = mid + 1;
            } else {
                // Peak lies on the left side (including mid)
                high = mid;
            }
        }
        // low == high is a peak index
        return low;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 1, 3, 5, 6, 4};

        int peakIndex = findPeakElement(nums);

        System.out.println("Peak element index: " + peakIndex);
        System.out.println("Peak element value: " + nums[peakIndex]);
    }
}

