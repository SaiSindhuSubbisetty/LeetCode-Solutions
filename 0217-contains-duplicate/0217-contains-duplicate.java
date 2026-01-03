class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> containsDuplicate = new HashSet<>();
        for(int num : nums){
            if(containsDuplicate.contains(num)){
                return true;
            }
            containsDuplicate.add(num);
        }
        return false;
    }
}