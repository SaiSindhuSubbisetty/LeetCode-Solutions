class Solution {
    public int missingNumber(int[] nums) {
        //cyclic sort;
        int i=0;
        while(i<nums.length){
            int correct = nums[i];
            if(nums[i] < nums.length && nums[i] != nums[correct])
            {
                swap(nums,i,correct);
            }
            else{
                i++;
            }
        }
        //searching and finding
        for(int index=0;index<nums.length;index++){
            if(nums[index] != index){
                return index;
            }
        }
        return nums.length;
    }
    public void swap(int[] nums,int start,int end){
        int temp = nums[start];
        nums[start] =nums[end];
        nums[end] = temp;
    }
}