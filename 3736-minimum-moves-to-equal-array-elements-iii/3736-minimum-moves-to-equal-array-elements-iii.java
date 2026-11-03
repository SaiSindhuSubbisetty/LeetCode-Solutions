import java.util.*;
class Solution {
    public int minMoves(int[] nums) {
        int maxi = nums[0];
        int moves = 0;

        for(int num:nums)
        {
            maxi = Math.max(num,maxi);
        }
        for(int num:nums)
        {
            moves += maxi-num;
        }
        return moves;
        
    }
}