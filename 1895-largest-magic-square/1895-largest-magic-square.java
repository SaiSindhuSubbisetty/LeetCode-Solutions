class Solution {
    public int largestMagicSquare(int[][] grid) {
        int r = grid.length, c = grid[0].length;
        int[][] rowSum = new int[r + 1][c + 1];
        int[][] colSum = new int[r + 1][c + 1];
        int[][] diag = new int[r + 1][c + 1];
        int[][] antidiag = new int[r + 1][c + 1];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int x = grid[i][j];
                rowSum[i + 1][j + 1] = rowSum[i + 1][j] + x;
                colSum[i + 1][j + 1] = colSum[i][j + 1] + x;
                diag[i + 1][j + 1] = diag[i][j] + x;
                antidiag[i + 1][j] = antidiag[i][j + 1] + x;
            }
        }

        for (int k = Math.min(r, c); k >= 2; k--) {
            if (isMagic(k, r, c, rowSum, colSum, diag, antidiag)) 
                return k;
        }
        return 1;
    }

    private boolean isMagic(int k, int r, int c, int[][] rowSum, int[][] colSum, int[][] diag, int[][] antidiag) {
        for (int i = 0; i <= r - k; i++) {
            for (int j = 0; j <= c - k; j++) {
                int s = diag[i + k][j + k] - diag[i][j];
                int anti = antidiag[i + k][j] - antidiag[i][j + k];
                if (s != anti) 
                    continue;
                boolean valid = true;
                for (int m = 0; m < k; m++) {
                    int row = rowSum[i + m + 1][j + k] - rowSum[i + m + 1][j];
                    int col = colSum[i + k][j + m + 1] - colSum[i][j + m + 1];
                    if (row != s || col != s) {
                        valid = false; break; 
                    }
                }
                if (valid) 
                    return true;
            }
        }
        return false;
    }
}