class Solution {
    public int minDeletionSize(String[] strs) {
        int stringSize = strs[0].length();
        int[] scores = new int[stringSize];

        for(int i = 0; i < strs.length; i++){
            for(int j = 0; j < stringSize; j++){
                int currScore = strs[i].charAt(j) - 'a';
                if(scores[j] != -1 && scores[j] <= currScore){
                    scores[j] = currScore;
                } else {
                    scores[j] = -1;
                }
            }
        }

        int deleted = 0;
        for(int i = 0; i < stringSize; i++){
            if(scores[i] == -1){
                deleted++;
            }
        }

        return deleted;
    }
}