class Solution {
    public int missingNumber(int[] nums) {
        int xOr = 0;
        for(int i=0;i<=nums.length;i++)
        {
            xOr = xOr ^ i;
        }
        for(int i=0;i<nums.length;i++)
        {
            xOr = xOr ^ nums[i];
        }
        return xOr;
    }
}