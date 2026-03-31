class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> seenNumber = new HashSet<>();

        for(int num: nums)
        {
            if(seenNumber.contains(num))
            {
                return true;
            }
            seenNumber.add(num);
        }
        return false;
        
    }
}