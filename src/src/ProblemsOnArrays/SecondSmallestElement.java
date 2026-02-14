package ProblemsOnArrays;

public class SecondSmallestElement {

    public static void main(String[] args) {

        int[] a = {10, 25, 3, 99, 45};
        int n = a.length;

        int smallest = a[0];
        int secondSmallest = Integer.MAX_VALUE;

        for (int i = 1; i < n; i++) {

            if (a[i] < smallest) {
                secondSmallest = smallest;
                smallest = a[i];
            }
            else if (a[i] > smallest && a[i] < secondSmallest) {
                secondSmallest = a[i];
            }
        }

        if (secondSmallest == Integer.MAX_VALUE) {
            System.out.println("No second smallest element");
        } else {
            System.out.println("Second smallest element = " + secondSmallest);
        }
    }
}

