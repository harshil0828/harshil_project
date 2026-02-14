package ProblemsOnArrays;

//This program is different from 2 pointers _5MaxConsecutiveOnes program
public class MaxConsecutiveOnes {

    public static void main(String[] args) {

        int num[] = {1, 1, 0, 1, 1, 1, 0, 1, 1};
        int count =0;
        int maxCount = 0;

        for(int i=0;i<num.length;i++)
        {
            if(num[i]==1)
            {
                count++;
                maxCount = Math.max(maxCount,count);
            }
            else {
                count=0;
            }
        }
        System.out.println("Max consecutive ones are " + maxCount);
    }
}
