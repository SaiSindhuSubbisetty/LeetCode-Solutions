class Solution {
    public int majorityElement(int[] nums) {
        int n= nums.length;
        Map<Integer,Integer> hmap = new HashMap<>();
        for(int num : nums)
        {
            hmap.put(num,hmap.getOrDefault(num, 0) + 1);
            if(hmap.get(num) > n/2)
            {
                return num;
            }
        }
        return -1;
         
    }
}