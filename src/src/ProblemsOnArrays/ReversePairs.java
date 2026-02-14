package ProblemsOnArrays;

public class ReversePairs {

    public static void main(String[] args) {

        int[] arr = {1, 3, 2, 3, 1};

        int result = reversePairs(arr);

        System.out.println("Number of reverse pairs = " + result);
    }

    public static int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    // Merge sort that returns count of reverse pairs
    private static int mergeSort(int[] nums, int low, int high) {

        if (low >= high) return 0;

        int mid = low + (high - low) / 2;
        int count = 0;

        count += mergeSort(nums, low, mid);
        count += mergeSort(nums, mid + 1, high);
        count += countPairs(nums, low, mid, high);
        merge(nums, low, mid, high);

        return count;
    }

    // Count reverse pairs across two sorted halves
    private static int countPairs(int[] nums, int low, int mid, int high) {

        int right = mid + 1;
        int count = 0;

        for (int left = low; left <= mid; left++) {
            while (right <= high && (long) nums[left] > 2L * nums[right]) {
                right++;
            }
            count += (right - (mid + 1));
        }
        return count;
    }

    // Standard merge function
    private static void merge(int[] nums, int low, int mid, int high) {

        int[] temp = new int[high - low + 1];
        int i = low, j = mid + 1, k = 0;

        while (i <= mid && j <= high) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        while (i <= mid) temp[k++] = nums[i++];
        while (j <= high) temp[k++] = nums[j++];

        for (int x = 0; x < temp.length; x++) {
            nums[low + x] = temp[x];
        }
    }
}
