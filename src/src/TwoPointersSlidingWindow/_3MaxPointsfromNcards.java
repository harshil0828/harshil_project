package TwoPointersSlidingWindow;

public class _3MaxPointsfromNcards {

    public static void main(String[] args) {

        int[] numbers = {6,2,3,4,7,2,1,7,1};
        int k = 4;
        int lsum = 0;
        int rsum = 0;
        int maxsum = 0;

        for(int i=0;i<k;i++)
        {
            lsum = lsum + numbers[i];
        }

        maxsum = lsum;

        int rindex = numbers.length-1;

        for(int i=k-1;i>=0;i--)
        {
            lsum = lsum - numbers[i];
            rsum = rsum + numbers[rindex];
            rindex = rindex-1;

            maxsum = Math.max(maxsum, rsum+lsum);
        }

        System.out.println("Max sum from n cards = " + maxsum);
    }
}
