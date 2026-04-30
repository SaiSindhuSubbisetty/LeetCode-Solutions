class Solution {

    public int recursion(int[][] grid,int k, int i, int j, int[][][] dp){

        // If we move out of grid => invalid path, return very small (to avoid choosing this path)
        if(i>=grid.length || j>=grid[0].length) return -1000000000;
        int score = 0;

        // If cell has 1 => gain 1 score, and picking it costs 1 move
        if(grid[i][j] == 1){
            score += 1; // +1
            k -= 1; // +1
        }
        // If cell has 2 => gain 2 score, but still picking costs only 1 move 
        else if(grid[i][j] == 2){
            score += 2; // +2
            k -= 1; // +1
        }
        // If cell has 0 => no score gained and no move cost 
        else {
            k -= 0; // +0
            score += 0; // +0
        }

        // If we exceed allowed picks => invalid path
        if(k<0) return -1000000000;

        // If reached destination, return the score gained at this cell
        if(i==grid.length-1 && j==grid[0].length-1){
            return score;
        }


        if(dp[i][j][k]!=-1){ // if already evaluated 
            return dp[i][j][k]; // return it directly
        }

        // move down + move right => explore
        int option1 = recursion(grid, k, i+1, j, dp);
        int option2 = recursion(grid, k, i, j+1, dp);

        // Store best result = current cell score + best of next moves
        return  dp[i][j][k] = score + Math.max(option1, option2);
    }
    public int maxPathScore(int[][] grid, int k) {
        int[][][] dp = new int[grid.length][grid[0].length][k+1];
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        int maxScore = recursion(grid, k, 0, 0, dp);
        return maxScore<0? -1: maxScore;
    }
}