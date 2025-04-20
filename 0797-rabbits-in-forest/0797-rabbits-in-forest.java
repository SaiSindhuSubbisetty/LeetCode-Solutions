class Solution {
    public int numRabbits(int[] answers) {
        int ans = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<answers.length;i++)
        {
            map.put(answers[i],map.getOrDefault(answers[i],0)+1);

        }
        for(int x:map.keySet()){
            int freq = map.get(x);
            ans += (freq/(x+1))*(x+1);
            if(freq%(x+1)!=0){
                ans+=(x+1);
            }
        }
        return ans;
        
    }
}