class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int n = nums.length;
        int max_diff = 0;
        for(int i=0;i<n;i++){
            int diff = nums[(i+1)%n];
            int di = Math.abs(nums[i]-diff);
            max_diff = Math.max(max_diff, di);
        }
        return max_diff;
    }
}