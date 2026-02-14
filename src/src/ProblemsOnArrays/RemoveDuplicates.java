package ProblemsOnArrays;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicates {

    //Brute for approach
    /*
    public static void main(String[] args) {

        int[] arr = {1, 1, 2, 2, 2, 3, 3};
        int n = arr.length;

        // Step 1: Insert elements into set
        Set<Integer> set = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(arr[i]);
        }

        // Step 2: Copy unique elements back to array
        int index = 0;
        for (int val : set) {
            arr[index] = val;
            index++;
        }

        // Print array after removing duplicates
        System.out.print("Result array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }*/

    public static int removeDuplicates(int[] arr) {

        Set<Integer> set = new LinkedHashSet<>();
        for (int num : arr) {
            set.add(num);
        }

        int index = 0;
        for (int val : set) {
            arr[index++] = val;
        }

        return index; // number of unique elements
    }

    public static void main(String[] args) {

        int[] arr = {1,1,2,2,2,3,3};

        int k = removeDuplicates(arr);

        System.out.print("Unique elements: ");
        for (int i = 0; i < k; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}

