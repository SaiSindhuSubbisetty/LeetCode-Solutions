class Solution {
    public int findDuplicate(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correct = nums[i] - 1;
            
            if (nums[i] != nums[correct]) {
                swap(nums, i, correct);
            } else {
                if (i != correct) {   // nums[i] already at correct place, but duplicate found
                    return nums[i];
                }
                i++;
            }
        }
        return -1; // should never reach here, as problem guarantees a duplicate
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
