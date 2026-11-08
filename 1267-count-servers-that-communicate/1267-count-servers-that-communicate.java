class Solution {
    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j] == 0)
                {
                    continue;
                }
                boolean canComunicate = false;

                //check other cells in the same row
                for(int col = 0;col<n;col++)
                {
                    if(col != j && grid[i][col] == 1)
                    {
                        canComunicate = true;
                        break;
                    }
                }

                //check other cells in the same col
                if(!canComunicate)
                {
                    for(int row =0;row<m;row++)
                    {
                        if(row != i && grid[row][j]==1)
                        {
                            canComunicate = true;
                            break;
                        }
                    }
                }
                if(canComunicate)
                {
                    count++;
                }
            }
        }
        return count;

        
    }
}