package ProblemsOnArrays;

public class MissingNumberBruteForce {

    public static void main(String[] args) {

        int num[] = {1, 2, 4, 5};
       // int n = 5;
        int flag=0;

        for(int i = 1; i < num.length; i++){
            flag=0;
            for(int j = 0; j < num.length-1; j++){
                if(num[j]==i)
                {
                    flag=i;
                    break;
                }
            }
            if(flag==0)
            {
                System.out.println("Missing number is " + i);
            }
        }

    }
}
