package ProblemsOnArrays;

public class MissingNumberOptimal {

    public static void main(String[] args) {

        int num[] = {1, 2, 4, 5};
        int n = num.length + 1;

/* Using Sum formula
        int expectedSum = n * (n + 1) / 2;

        int actualSum = 0;
        for (int x : num) {
            actualSum += x;
        }

        System.out.println(expectedSum - actualSum);

        */

//using XOR
        int xor = 0;

        for (int i = 1; i <= n; i++) xor ^= i;
        for (int x : num) xor ^= x;

        System.out.println(xor);

    }
}
