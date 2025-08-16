class Solution {
    public int removeDuplicates(int[] nums) {
        //slow and fast poointers for finding the unique elements
        int slow = 0;
        for(int fast = 1;fast<nums.length;fast++)
        {
            if(nums[fast] != nums[slow])
            {
                slow++;
                nums[slow] = nums[fast];
            }

        }
        return slow+1;
        
    }
}