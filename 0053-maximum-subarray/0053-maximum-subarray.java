import java.util.*;
class Solution {
    public int maxSubArray(int[] nums) 
    {
        int maxSum = Integer.MIN_VALUE;
        int curSum = 0;
        for(int num : nums)
        {
            curSum += num;
            maxSum = Math.max(curSum, maxSum);
            if(curSum < 0)
            {
                curSum = 0;
            }
        }
        return maxSum;
    }
}
//Kadane's Algorithm
//TC : 0(n)
//SC : 0(1)