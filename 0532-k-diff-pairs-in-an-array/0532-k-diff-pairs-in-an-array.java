class Solution {
    public int findPairs(int[] nums, int k) {
        int n =  nums.length;
        int count = 0;
        if(k<0) return 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(int num : map.keySet())
        {
            if(k == 0)
            {
                if(map.get(num)>=2)
                {
                    count++;
                }
            }
            else{
                if(map.containsKey(num+k))
                {
                    count++;
                }
            }
        }
        return count;
        
    }
}