package ProblemsOnArrays;

import java.util.HashMap;

public class FindSingleElement {

    public static void main(String[] args) {

        /* using has array. This solution hsa time complexity of 3N

        int[] arr = {1, 1, 2, 3, 3, 4, 4};
        int n = arr.length;

        // Step 1: Find maximum element
        int maxi = arr[0];
        for (int i = 1; i < n; i++) {
            maxi = Math.max(maxi, arr[i]);
        }

        // Step 2: Create hash array
        int[] hash = new int[maxi + 1];

        // Step 3: Store frequencies
        for (int i = 0; i < n; i++) {
            hash[arr[i]]++;
        }

        // Step 4: Find element that appears once
        for (int i = 0; i < n; i++) {
            if (hash[arr[i]] == 1) {
                System.out.println("Element appearing once: " + arr[i]);
                break;
            }
        }

         */

        //Below solution is using map.It is generally used when input array has too many elements
        //it has TC of Nlog N/2+1 + N/2+1

        /*
        int[] arr = {1, 1, 2, 3, 3, 4, 4};
        // Step 1: Create HashMap for frequency
        HashMap<Integer, Integer> map = new HashMap<>();

        // Step 2: Count frequency
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 3: Find element with frequency 1
        for (int num : arr) {
            if (map.get(num) == 1) {
                System.out.println("Element appearing once: " + num);
                break;
            }
        }
*/

//Approach 3 using XOR


        int[] arr = {1, 1, 2, 3, 3, 4, 4};

        int xor = 0;

        // XOR all elements
        for (int num : arr) {
            xor ^= num;
        }

        System.out.println("Element appearing once: " + xor);


    }
}
