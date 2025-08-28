class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        for (int t = 0; t < n; t++){
            for (int i = 0; i < n - 1; i++){
                for (int j = 0; j < n - 1; j++){
                    if (j > i){
                        if (grid[i][j] > grid[i + 1][j + 1]){
                            int tmp = grid[i][j];
                            grid[i][j] = grid[i + 1][j + 1];
                            grid[i + 1][j + 1] = tmp;
                        }
                    } else {
                        if (grid[i][j] < grid[i + 1][j + 1]){
                            int tmp = grid[i][j];
                            grid[i][j] = grid[i + 1][j + 1];
                            grid[i + 1][j + 1] = tmp;
                        }
                    }
                }
            }
        }
        return grid;
    }
}