package ProblemsOnArrays;

public class SecondLargestElement {

    public static void main(String[] args) {

        int[] a = {10, 25, 3, 99, 45};
        int n = a.length;

        int largest = a[0];
        int secondLargest = Integer.MIN_VALUE;

        for (int i = 1; i < n; i++) {

            if (a[i] > largest) {
                secondLargest = largest;
                largest = a[i];
            }

            /*Your code only updates slargest when a new largest is found
            But this case is missed:

            {10, 99, 45}
            Hence else if is needed
            */
            else if (a[i] < largest && a[i] > secondLargest) {
                secondLargest = a[i];
            }
        }

        if (secondLargest == Integer.MIN_VALUE) {
            System.out.println("No second largest element");
        } else {
            System.out.println("Second largest element = " + secondLargest);
        }
    }
}

