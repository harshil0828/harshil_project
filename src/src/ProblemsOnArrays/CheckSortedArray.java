package ProblemsOnArrays;

public class CheckSortedArray {

    public static boolean isSorted(int[] arr) {

        int n = arr.length;

        for (int i = 1; i < n; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;   // not sorted
            }
        }
        return true;            // sorted
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 2, 3, 3, 4};

        if (isSorted(arr)) {
            System.out.println("Array is sorted");
        } else {
            System.out.println("Array is not sorted");
        }
    }
}
