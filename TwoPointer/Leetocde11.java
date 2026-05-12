package TwoPointer;

public class Leetocde11
{
    public static void main(String[] args)
    {

    }

    public int maxArea(int[] height)
    {
        int i = 0;
        int j = height.length - 1;
        int area = Integer.MIN_VALUE;
        while ( i< j )
        {
            area = Math.max ( Math.min ( height[i] , height[j] )*( j - i ) , area  );
            if( height [i] <= height[j] ) i++;
            else j --;


        }
        return area;
    }
}
