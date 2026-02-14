package ProblemsOnArrays;

import java.util.ArrayList;
import java.util.List;

public class IntersectionBruteForce {

    public static List<Integer> intersection(int[] arr1, int[] arr2) {

        int n1 = arr1.length;
        int n2 = arr2.length;

        boolean[] visited = new boolean[n2];
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n1; i++) {

            for (int j = 0; j < n2; j++) {

                if (arr1[i] == arr2[j] && !visited[j]) {
                    result.add(arr1[i]);
                    visited[j] = true;
                    break; // move to next element of arr1
                }

                // Since arrays are sorted, no need to continue
                if (arr2[j] > arr1[i]) {
                    break;
                }
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
