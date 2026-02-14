package ProblemsOnArrays;

public class LeftRotateBruteForce {

    public static void leftRotate(int[] arr, int d) {
        int n = arr.length;
        d = d % n;

        for (int i = 0; i < d; i++) {
            int temp = arr[0];

            for (int j = 1; j < n; j++) {
                arr[j - 1] = arr[j];
            }

            arr[n - 1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        int d = 2;

        leftRotate(arr, d);

        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}
