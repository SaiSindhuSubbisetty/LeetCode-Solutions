class Solution {
    public int findLucky(int[] arr) {
        Map<Integer,Integer> hmap = new HashMap<>();
        for(int num: arr){
            hmap.put(num, hmap.getOrDefault(num,0) + 1);
        }

        int maxLucky = -1;
        for(Map.Entry<Integer, Integer> entry : hmap.entrySet())
        {
            int key = entry.getKey();
            int value = entry.getValue();

            if(key == value && key > maxLucky)
            {
                maxLucky = key;
            }
        }
        return maxLucky;
        
    }
}