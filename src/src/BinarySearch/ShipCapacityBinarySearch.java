package BinarySearch;

public class ShipCapacityBinarySearch {

    public static int shipWithinDays(int[] weights, int days) {

        int low = 0, high = 0;

        for (int w : weights) {
            low = Math.max(low, w); // at least max weight
            high += w;             // at most sum
        }

        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canShip(weights, days, mid)) {
                ans = mid;
                high = mid - 1;  // minimize capacity
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private static boolean canShip(int[] weights, int days, int capacity) {

        int dayCount = 1;
        int load = 0;

        for (int w : weights) {
            if (load + w > capacity) {
                dayCount++; // need a new day
                load = w;// start new day with this package
            } else {
                load += w;// add package to current day
            }
        }
        return dayCount <= days;
    }

    public static void main(String[] args) {

        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;

        System.out.println("Minimum capacity: " + shipWithinDays(weights, days));
    }
}

