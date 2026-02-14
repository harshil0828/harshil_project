package ProblemsOnArrays;

public class LargestElementInArray {

    public static void main(String[] args) {

        int[] a = {10, 25, 3, 99, 45};
        int n = a.length;

        int largest = a[0];   // assume first element is largest

        for (int i = 1; i < n; i++) {
            if (a[i] > largest) {
                largest = a[i];
            }
        }

        System.out.println("Largest element in the array = " + largest);
    }
}

