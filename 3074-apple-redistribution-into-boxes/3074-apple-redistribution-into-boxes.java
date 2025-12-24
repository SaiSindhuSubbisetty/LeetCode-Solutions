class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int sum = 0;
        for(int i:apple){
            sum+=i;
        }
        Arrays.sort(capacity);
        int count = 0;
        int i = capacity.length-1;
        while(sum>=1){
            sum -= capacity[i];
            i--;
            count++;
        }
        return count;
        
    }
}