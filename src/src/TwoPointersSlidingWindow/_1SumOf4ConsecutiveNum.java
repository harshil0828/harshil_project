package TwoPointersSlidingWindow;

public class _1SumOf4ConsecutiveNum {
    public static void main(String[] args) {

        int[] numbers = {-1, 2, 3, 3, 4, 5, -1};
        int k = 4;

        int sum = 0;

        // 1️⃣ First window sum
        for (int i = 0; i < k; i++) {
            sum += numbers[i];
        }

        int maxSum = sum;

        int l = 0;

        // 2️⃣ Slide the window
        for (int r = k; r < numbers.length; r++) {
            sum = sum - numbers[l];
            l++;
            sum = sum + numbers[r];

            maxSum = Math.max(maxSum, sum);
        }

        System.out.println("Max sum of 4 consecutive numbers = " + maxSum);
    }
}
