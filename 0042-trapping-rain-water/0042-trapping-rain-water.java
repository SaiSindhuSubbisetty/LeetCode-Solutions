class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length-1;
        int leftMax = 0;
        int rightMax = height[right];
        int total = 0;
        while(left < right)
        {
            if(height[left] < height[right])
            {
                leftMax = Math.max(leftMax,height[left]);
                if(leftMax - height[left] > 0)
                {
                    total = total + leftMax-height[left];
                }
                left++;
            }
            else{
                rightMax = Math.max(rightMax, height[right]);
                if(rightMax-height[right] > 0)
                {
                    total = total + rightMax-height[right];
                }
                right--;
            }
        }
        return total;
        
    }
}