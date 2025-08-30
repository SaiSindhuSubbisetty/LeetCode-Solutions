class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        //cyclic sort;
        int i=0;
        while(i<nums.length){
            int correct = nums[i]-1;
            if(nums[i] != nums[correct])
            {
                swap(nums,i,correct);
            }
            else{
                i++;
            }
        }
        List<Integer> res = new ArrayList<Integer>();
        for(int index = 0;index<nums.length;index++){
            if(nums[index] != index+1){
                res.add(index+1);
            }
        }
        return res;
    }
    public void swap(int[] nums,int start,int end){
        int temp = nums[start];
        nums[start] =nums[end];
        nums[end] = temp;
    }
        
}
