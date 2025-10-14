import java.util.*;
class Solution {
    public int minimumRounds(int[] tasks) {
        
        Map<Integer,Integer> countMap = new HashMap<>();

        for(int task:tasks)
        {
            countMap.put(task, countMap.getOrDefault(task,0)+1);

        }
        int totalRounds = 0;
        for(int freq : countMap.values()){
            if(freq == 1)
            {
                return -1;
            }
            if(freq % 3 == 0)
            {
                totalRounds += freq/3;
            }
            else{
                totalRounds += (freq/3)+1;
            }
        }
        return totalRounds;
    }
}
    