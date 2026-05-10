package PrefixSum;

import java.util.HashMap;

public class Leetcode974 {
    public static void main(String[] args) {

    }

        public int subarraysDivByK(int[] nums, int k) {
            HashMap< Integer, Integer > map = new HashMap<>();

            int numOfSubarray = 0;
            int prefixSum = 0 ;
            int rem = 0;
            map.put( 0, 1 );
            for ( int ele : nums )
            {
                prefixSum += ele;
                rem = ( prefixSum % k + k ) % k  ;
                // if( rem < 0 ) rem += k;
                if( map.containsKey( rem ) ) numOfSubarray += map.get( rem );
                // Here we are not using else as we want all valid sub-array we don't want
                // the lowest index so, we are not using the else case to put only the last index like
                // leetcode 525
                map.put( rem , map.getOrDefault( rem , 0) + 1 );
                // means we got the left subarray with whom if we minus we got a subarray k whose sum is equal to n*k where Z ( Integer both postive and negative ) belongs
            }
            return numOfSubarray;
        }
    }

