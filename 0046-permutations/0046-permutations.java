class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, 0, res);
        return res;
    }

    private void backtrack(int[] nums, int start, List<List<Integer>> res) {
        if (start == nums.length) {
            List<Integer> list = new ArrayList<>();
            for(int num : nums){
                list.add(num);
            }
            res.add(list);
        }
        for(int i=start;i<nums.length;i++)
        {
            swap(nums,i,start);
            backtrack(nums,start+1,res);
            swap(nums,i,start);
        }
    }
    private void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}