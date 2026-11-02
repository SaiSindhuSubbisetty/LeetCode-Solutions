class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int moves = 0;
        int left = 0;
        int right = nums.length-1;
        while(left < right)
        {
            moves += nums[right]-nums[left];
            left++;
            right--;
        }
        return moves;

        
    }
}