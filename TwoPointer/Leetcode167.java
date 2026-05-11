package TwoPointer;

public class Leetcode167 {
    public static void main(String[] args)
    {

    }

    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            /*
We will use two pointer as we are given the array is in ascending order
so if sum > target we will move the right pointer
if some is less then < target we will move the left pointer
         */
            int i = 0;
            int j = numbers.length - 1;
            int [] ans = new int [2];
            while( i<j )
            {
                if( numbers[i] + numbers[j] > target ) j--;
                else if ( numbers[i] + numbers[j] < target ) i++;
                else
                {
                    ans [0] = i+1;
                    ans [1] = j+1;
                    i++;
                    j--;
                }

            }
            return ans;
        }
    }
}
