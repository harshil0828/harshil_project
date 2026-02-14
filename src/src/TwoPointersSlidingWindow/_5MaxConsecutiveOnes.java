package TwoPointersSlidingWindow;

/*Given a binary array (0s and 1s) and an integer k,
you can flip at most k zeros to ones.
Find the maximum number of consecutive 1s you can get.*/


public class _5MaxConsecutiveOnes {

    public static void main(String[] args) {

        _5MaxConsecutiveOnes l =  new _5MaxConsecutiveOnes();
        int[] numbers = {1,1,1,0,0,0,1,1,1,1,0};
        int len = l.longestOnes(numbers,2);
        System.out.println("Max len of longest ones = " + len);

    }
        public int longestOnes(int[] nums, int k) {
            int l=0,r=0,max=0,zero=0,n=nums.length;
            while(r<n){
                if(nums[r]==0) zero++;
                if(zero>k){
                    if(nums[l]==0) zero--;
                    l++;
                }
                if(zero<=k){
                    max=Math.max(max,r-l+1);
                }
                r++;
            }
            return max;
        }
    }

