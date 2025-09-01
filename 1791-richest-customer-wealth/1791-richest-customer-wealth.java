import java.util.*;
class Solution {
    public int maximumWealth(int[][] accounts) {
        int max = Integer.MIN_VALUE;
        for(int[] acc : accounts){
            int rowSum = 0;
            for(int ant : acc){
                rowSum += ant;
            }
            if(rowSum > max){
                max = rowSum;
            }
        }
        return max;
        
    }
}