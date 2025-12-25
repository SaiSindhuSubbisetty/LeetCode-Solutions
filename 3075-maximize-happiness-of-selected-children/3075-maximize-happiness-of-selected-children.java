class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);        
        long score = 0;
        int n = happiness.length;
        
        for (int i = 0; i < k; i++) {
            long currentVal = happiness[n - 1 - i] - i;
            if (currentVal > 0) {
                score += currentVal;
            } else {
                break; 
            }
        }
        return score;
    }
}