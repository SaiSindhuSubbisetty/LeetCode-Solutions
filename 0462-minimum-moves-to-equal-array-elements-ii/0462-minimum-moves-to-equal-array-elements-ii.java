class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int moves = 0;
        int n = nums.length;
        int median = nums[n/2];
        for(int num:nums)
        {
            moves += Math.abs(num-median);
        }
        return moves;

        
    }
}