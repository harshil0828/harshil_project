package ProblemsOnArrays;

public class MissingNumberBetter {

    public static void main(String[] args) {

        int num[] = {1, 2, 4, 5};
        int n = 5;

        int hash[] = new int[num.length+2];

        /*for(int i=0;i<num.length+1;i++)
        {
            hash[i]=0;
        }*/

        for(int i=0;i< num.length;i++)
        {
            hash[num[i]]=1;
        }

        for(int i=1;i<= num.length+1;i++)
        {
            if(hash[i]==0)
            {
                System.out.println("Missing Number is " + i);
                break;
            }
        }
    }
}
