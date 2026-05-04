package PrefixSum;


class Solution {
    public int[] runningSum(int[] nums) {
        for(int i =1;i<nums.length;i++)nums[i]+=nums[i-1];
        return nums;
        /*
        T.C =o(N-1)
        S.C =O(1)
        */
    }
}
public class Leetcode1480 {
}
