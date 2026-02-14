package BinarySearch;

public class MinDaysBouquets {

    public static int minDays(int[] bloomDay, int m, int k) {

        // Impossible case
        if ((long) m * k > bloomDay.length) {
            return -1;
        }

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        // Find search range
        for (int day : bloomDay) {
            low = Math.min(low, day);
            high = Math.max(high, day);
        }

        int ans = -1;

        // Binary search on days
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canMakeBouquets(bloomDay, m, k, mid)) {
                ans = mid;
                high = mid - 1;   // try to minimize days
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    // Check if we can make m bouquets in 'day' days
    private static boolean canMakeBouquets(int[] bloomDay, int m, int k, int day) {

        int bouquets = 0;
        int count = 0;

        for (int bloom : bloomDay) {

            if (bloom <= day) {
                count++;
                if (count == k) {
                    bouquets++;
                    count = 0;
                }
            } else {
                count = 0;
            }
        }
        return bouquets >= m;
    }

    public static void main(String[] args) {

        int[] bloomDay = {7,7,7,7,13,11,12,7};
        int m = 2; //2 bouquests
        int k = 3; // of 3 adjacent flowers

        System.out.println("Minimum days: " + minDays(bloomDay, m, k));
    }
}

