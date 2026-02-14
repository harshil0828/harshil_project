package ProblemsOnArrays;

import java.util.ArrayList;

public class MoveZerosToEnd {

    /*
    // Swap function
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void moveZeros(int[] arr) {
        int n = arr.length;

        int j = -1;

        // Step 1: find the first zero
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                j = i;
                break;
            }
        }

        // If no zero found, array is already valid
        if (j == -1) return;

        // Step 2: swap non-zero elements with zero
        for (int i = j + 1; i < n; i++) {
            if (arr[i] != 0) {
                swap(arr, i, j);
                j++;   // move j to next zero position
            }
        }
    }

    public static void main(String[] args) {

        int[] arr = {1,0,2,3,2,0,0,4,5,1};

        moveZeros(arr);

        System.out.print("Array after moving zeros: ");
        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
    */

    //Brute force approach

    static void moveZeros(int[] arr) {
        int n = arr.length;

        // Step 1: store non-zero elements in temp list
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                temp.add(arr[i]);
            }
        }

        // Step 2: copy non-zero elements back to array
        int index = 0;
        for (int i = 0; i < temp.size(); i++) {
            arr[index++] = temp.get(i);
        }
        // Step 3: fill remaining positions with zero
        while (index < n) {
            arr[index++] = 0;
        }
    }

    public static void main(String[] args) {

        int[] arr = {1,0,2,3,2,0,0,4,5,1};

        moveZeros(arr);

        System.out.print("Array after moving zeros: ");
        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}

