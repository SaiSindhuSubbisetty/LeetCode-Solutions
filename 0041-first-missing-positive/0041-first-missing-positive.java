class Solution {
    public int firstMissingPositive(int[] nums) {
          int i = 0;
        while (i < nums.length) {
            int correct = nums[i]-1;
            
            if (nums[i] > 0 && nums[i] < nums.length && nums[i] != nums[correct]) {
                swap(nums, i, correct);
            } else {
                i++;
            }
        }
        for(int idx=0;idx<nums.length;idx++)
        {
            if(nums[idx] != idx+1)
            {
               return idx+1;
            }
        }
        return nums.length+1;
        
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
        
}