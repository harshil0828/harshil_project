package TwoPointersSlidingWindow;

import java.util.LinkedHashMap;
import java.util.Map;

/*
Problem is to find either of below
Fruit Into Baskets
Longest substring with at most K distinct characters
*/

public class _6FruitsIntoBaskets {

    public static void main(String[] args) {

        _6FruitsIntoBaskets l =  new _6FruitsIntoBaskets();
        Integer[] numbers = {3,3,3,1,2,1,1,2,3,3,4};
        int len = l.totalElements(numbers);
        System.out.println("Max len of distinct fruits / numbers = " + len);

    }

        public static int totalElements(Integer[] arr) {
            // code here
            int l=0; int r=0; int maxlen=0;int k=2;
            Map<Integer,Integer> map=new LinkedHashMap<>();
            while(r<arr.length){
                map.put(arr[r],map.getOrDefault(arr[r],0)+1);
                if(map.size()>k){
                    while(map.size()>k){
                        map.put(arr[l],map.get(arr[l])-1);
                        if(map.get(arr[l])==0){
                            map.remove(arr[l]);
                        }
                        l++;
                    }

                }
                if(map.size()<=k){
                    maxlen=Math.max(maxlen,r-l+1);
                }
                r++;
            }
            return maxlen;

        }
    }
