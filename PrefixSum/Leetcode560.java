package PrefixSum;


import java.util.HashMap;

public class Leetcode560 {
    public static void main(String[] args) {
    }
        public int subarraySum(int[] arr , int k)
        {
            int count =0;
            int sum = 0;

            for( int i = 0 ; i < arr.length-1  ; i++ )
            {


                if(  arr[i] == k ) count++;

                sum = arr[i];

                for( int j = i+1 ; j<arr.length; j++  )
                {

                    if( sum + arr[j]  == k )count ++;
                    sum +=arr[j];
                }

            }

            if( arr[ arr.length-1 ] == k )count++;
            return count ;
        /*
        T.C =O(N^2)
        S.C =O(1)
        */
        }
    public int subarraySum_Optimize(int[] nums, int k) {
        int sum =  0;
    HashMap < Integer , Integer > map = new HashMap<>();
         map.put( sum, 1 );
    int count = 0;

         for( int i = 0 ; i < nums.length ; i++ )
    {
        sum += nums [i];

        if( map.containsKey ( sum -  k ) ) count += map.get( sum - k );
        map.put( sum , map.getOrDefault(sum,0) + 1 );
    }

        return count ;
}
}

