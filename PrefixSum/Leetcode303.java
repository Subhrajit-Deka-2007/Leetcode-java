package PrefixSum;


class NumArray {
    int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int left, int right) {
        int[] prefix = new int[nums.length + 1];
        for (int i = 1; i < prefix.length; i++)
            prefix[i] = prefix[i - 1] + nums[i - 1];

        return prefix[right + 1] - prefix[left];
    }
    /*
    T.C = O(N+N)
    S.C =O(N+1)
    */
}
public class Leetcode303 {


/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
}
