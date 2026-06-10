import java.util.LinkedList;
import java.util.Queue;
class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return -1;
        int m = grid.length, n = grid[0].length;
        int freshCount = 0;
        Queue<int[]> rottenQueue = new LinkedList<>();
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j] == 1)
                {
                    freshCount++;
                }else if(grid[i][j] == 2)
                {
                    rottenQueue.offer(new int[]{i,j});
                }
            }
        }
        if(freshCount == 0) return 0;

        int minutes = 0;
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        while(!rottenQueue.isEmpty())
        {
            int size = rottenQueue.size();
            for(int i=0;i<size;i++)
            {
                int[] rotten = rottenQueue.poll();
                for(int[] dir : directions)
                {
                    int x = rotten[0]+dir[0];
                    int y = rotten[1]+dir[1];
                    if(x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1)
                    {
                        grid[x][y] = 2;
                        freshCount--;
                        rottenQueue.offer(new int[]{x,y});
                    }

                }

            }
            minutes++;
        }
        return freshCount == 0 ? minutes-1:-1;
        
    }
}