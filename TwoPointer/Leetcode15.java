package TwoPointer;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
public class Leetcode15
{
    public static void main(String[] args)
    {
      int [] nums =  {-1,0,1,2,-1,-4};
      Arrays.sort(nums);
      List< List<Integer>> ans ;
       ans =  threeSum_1(nums);
       System.out.println(" ans "+ ans );
    }

    public static List<List<Integer>> threeSum_1(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // skip duplicate i

            int target = -nums[i];
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int sum = nums[j] + nums[k];
                if (sum > target) {
                    k--;
                } else if (sum < target) {
                    j++;
                } else {
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++; // skip duplicate j
                    while (j < k && nums[k] == nums[k + 1]) k--; // skip duplicate k
                }
            }
        }
        return ans;
    }
    /*
    That’s the right mindset—keep another tool in your
     "algorithmic toolbox" for when constraints change.
      The HashSet approach is great for when you can't (or don't want to)
      use two pointers, or if you are dealing with a stream of data.
      Here is the quick summary for your future reference:The 3Sum
       HashSet Strategy ($O(N^2)$ Time, $O(N)$ Space)Instead of using
       two pointers to "meet in the middle," you use a Set to find the
       "missing piece" of the triplet, just like in the basic Two Sum problem.
       The Workflow:Sort the array (this is still the easiest way to handle
       duplicate triplets).Outer Loop ($i$): Iterate through the array. Skip
       duplicates as usual.Inner Loop ($j$): Start from $i+1$.The Goal: Find a
        value $k$ such that $nums[i] + nums[j] + k = 0$.The Check: Check if
         target - nums[j] exists in your HashSet.The Update: If it doesn't exist,
         add nums[j] to the HashSet and keep moving.Reset: Clear the HashSet for
       every new $i$ to ensure you are only looking at numbers available for the
        current triplet.
     */



    public List<List<Integer>> threeSum_2(int[] nums) {
        // // The mistake i have made here the array is not sorted first we have to sort the array as the approach i am trying to use needs
        // // a sorted array
        Arrays.sort(nums);

        int j ;
        int k;

        int target ;
        List< List<Integer> > ans = new ArrayList<>();
        List< Integer > list ;


        for ( int i = 0 ; i < nums.length-2; i++ )
        // j will go till nums.length - 2 , i will go tll nums.length - 3 and k will go till nums.length -1
        {  // if( i == nums.length -2 ) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            target = 0;
            target -= nums[i] ;
            j = i+1;
            k = nums.length - 1 ;

            while( j<k )
            {
                list =  new ArrayList<>();
                if( nums[j] + nums[k] > target ) k--;
                else if( nums[j] + nums[k] < target )j++;
                else  {
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    j++;// first increment and decrement the j and k repsectively from that
                    // particular pair
                    // i forgot to increment the j and decrement the k for which it got stucked in the infinite loop
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++; // skip duplicate j
                    while (j < k && nums[k] == nums[k + 1]) k--;
                    ans.add(list);
                    // System.out.println( ans );
                }
            }

        }

        return ans;
    }
}


