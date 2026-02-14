package ProblemsOnArrays;

import java.util.ArrayList;
import java.util.List;

public class IntersectionTwoPointers {

    public static List<Integer> intersection(int[] a, int[] b) {

        int i = 0, j = 0;
        int n = a.length, m = b.length;

        List<Integer> result = new ArrayList<>();

        while (i < n && j < m) {

            if (a[i] < b[j]) {
                i++;
            }
            else if (b[j] < a[i]) {
                j++;
            }
            else {
                result.add(a[i]);
                i++;
                j++;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int[] arr1 = {1, 2, 2, 3, 4};
        int[] arr2 = {2, 2, 3, 5};

        List<Integer> ans = intersection(arr1, arr2);

        System.out.print("Intersection: ");
        for (int x : ans) {
            System.out.print(x + " ");
        }
    }
}

