class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        hmap.put(0,1);
        int sum = 0, count = 0;
        for(int num : nums)
        {
            sum += num;
            if(hmap.containsKey(sum-k))
            {
                count += hmap.get(sum-k);
            }
            hmap.put(sum, hmap.getOrDefault(sum,0)+1);
        }
        return count;
        
    }
}