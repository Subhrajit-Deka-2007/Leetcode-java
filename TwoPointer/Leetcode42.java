package TwoPointer;

public class Leetcode42 {
    public static void main(String[] args)
    {

    }

        public int trap(int[] height)
        {
            int leftMax  = 0 ;
            int rightMax = 0 ;

            int i = 0;
            int j = height.length - 1 ;

            int water = 0;
            while ( i <= j )
            {
                if( leftMax  <= rightMax )
                {

                    leftMax = Math.max ( leftMax , height[ i ] );
                    water +=  leftMax - height[i];
                    i++;
                }
                else
                {
                    rightMax = Math.max( rightMax, height[ j ] );
                    water += rightMax - height[j];
                    j--;
                }

            }

            return water;
        }
    }

