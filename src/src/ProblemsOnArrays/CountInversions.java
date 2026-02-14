package ProblemsOnArrays;

public class CountInversions {

    public static void main(String[] args) {

        int[] arr = {5, 3, 2, 4, 1};

        long count = mergeSort(arr, 0, arr.length - 1);

        System.out.println("Number of inversion pairs = " + count);
    }

    // Recursive merge sort
    public static long mergeSort(int[] arr, int low, int high) {

        long count = 0;

        if (low < high) {
            int mid = low + (high - low) / 2;

            //count here is - It returns the total number of inversion pairs in the part of the array it processed.
            count += mergeSort(arr, low, mid);
            count += mergeSort(arr, mid + 1, high);
            count += merge(arr, low, mid, high);
        }

        return count;
    }

    // Merge step + count inversions
    public static long merge(int[] arr, int low, int mid, int high) {

        int[] temp = new int[high - low + 1];
        int i = low;        // left pointer
        int j = mid + 1;    // right pointer
        int k = 0;
        long invCount = 0;

        while (i <= mid && j <= high) {

            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                invCount += (mid - i + 1); // key inversion logic
            }
        }

        // Copy remaining elements
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= high) {
            temp[k++] = arr[j++];
        }

        // Copy back to original array
        for (int x = 0; x < temp.length; x++) {
            arr[low + x] = temp[x];
        }

        return invCount;
    }
}

