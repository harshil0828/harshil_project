package ProblemsOnArrays;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class UnionOfTwoSortedArrays {
/*
Brute for approach

    public static void main(String[] args) {

        int[] arr1 = {1, 1, 2, 3, 4, 5};
        int[] arr2 = {2, 3, 4, 4, 5};

        Set<Integer> set = new LinkedHashSet<>();

        // Insert elements of first array
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }

        // Insert elements of second array
        for (int i = 0; i < arr2.length; i++) {
            set.add(arr2[i]);
        }
        // Print union
        System.out.print("Union of arrays: ");
        for (int val : set) {
            System.out.print(val + " ");
        }
    }
    */

    //2 pointers approach

    public static List<Integer> union(int[] a, int[] b) {

        int n = a.length;
        int m = b.length;

        int i = 0, j = 0;
        List<Integer> unionArr = new ArrayList<>();

        // Traverse both arrays
        while (i < n && j < m) {

            if (a[i] <= b[j]) {
                //below line means Is the current element different from the last element already added
                if (unionArr.size() == 0 || unionArr.get(unionArr.size() - 1) != a[i]) {
                    unionArr.add(a[i]);
                }
                i++;
            } else {
                if (unionArr.size() == 0 || unionArr.get(unionArr.size() - 1) != b[j]) {
                    unionArr.add(b[j]);
                }
                j++;
            }
        }

        // Add remaining elements from array a
        while (i < n) {
            if (unionArr.get(unionArr.size() - 1) != a[i]) {
                unionArr.add(a[i]);
            }
            i++;
        }

        // Add remaining elements from array b
        while (j < m) {
            if (unionArr.get(unionArr.size() - 1) != b[j]) {
                unionArr.add(b[j]);
            }
            j++;
        }
        return unionArr;
    }

    public static void main(String[] args) {

        int[] arr1 = {1, 1, 2, 3, 4, 5};
        int[] arr2 = {2, 3, 4, 4, 5};

        List<Integer> result = union(arr1, arr2);

        System.out.print("Union of arrays: ");
        for (int x : result) {
            System.out.print(x + " ");
        }
    }
}
