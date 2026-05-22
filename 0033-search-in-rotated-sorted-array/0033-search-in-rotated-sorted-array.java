class Solution {
    public int search(int[] nums, int target) {
        if(nums[0] == target) {
            return 0;
        }
        if(nums[nums.length - 1] == target) {
            return nums.length -1 ;
        }
        int start = 0; 
        int end = nums.length - 1;
        int mid = (start + end) / 2;
        while(target != nums[mid]) {
            if((nums[mid] < nums[end] && (target > nums[end] || target < nums[mid])) || (nums[mid] > nums[end] && target < nums[mid] && target > nums[end])) {
                end = mid;
            } else {
                start = mid;
            }
            if(mid == (start + end)/2) {
                mid = -1;
                break;
            }
            mid = (start + end) /2;
        }
        return mid;
        
    }
}