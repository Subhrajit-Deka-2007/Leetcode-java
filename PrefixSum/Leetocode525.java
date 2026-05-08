package PrefixSum;

import java.util.HashMap;

public class Leetocode525 {
    public static void main(String[] args) {

    }
    public int findMaxLength(int[] nums)
    {
        int sum = 0 ;
        int length = 0  ;
        int count = 0;
        HashMap< Integer , Integer > map = new HashMap <> ();
        map.put( 0 , -1 );
// means the oth value is present outside the array before 0 th index at -1 index
        for ( int i = 0 ; i < nums.length ; i++ )
        {
            if( nums[i] == 0 )sum+=-1;
            else sum += 1;
            count ++;
            if( map.containsKey ( sum - 0) )
                length = Math.max( length , i - map.get( sum ) );


            else  map.put( sum ,  i);
           /*
           We need the earliest index so we are not overwriting the index for the same
           value. As we want the maximum value for minimum value I would have done
           is overwriitng the value with the newest indexes
           */
            /*
            Adding 1 simply means we have seen that particular sum once again
            */

        }
        return length ;// pairs*2 as it represents the real size
    }
}
