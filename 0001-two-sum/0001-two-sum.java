class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hmap = new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            int compliment = target - nums[i];
            if(hmap.containsKey(compliment))
            {
                return new int[] {hmap.get(compliment), i};
            }
            hmap.put(nums[i],i);
        }
        return new int[]{};
    }
}