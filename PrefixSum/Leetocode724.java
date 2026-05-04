package PrefixSum;


public class Leetocode724 {

    public int pivotIndex(int[] nums) {
        /*
        Okay we will make one prefix array of size n + 1
        */
        int [] prefix = new int [ nums.length  + 1 ];

        for( int i = 1 ; i<prefix.length ; i++ ) prefix[i] = prefix[i-1]+ nums[i-1];

        for ( int i = 0 ; i<nums.length ; i++ )

            if( prefix[i] == (prefix[nums.length] - prefix[i+1]) ) return i;



        return -1 ;
        /*
        T.C =O(N)
        S.C =O(N+1)
        */
    }
}
