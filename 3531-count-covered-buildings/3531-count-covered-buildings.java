class Solution {

    public int countCoveredBuildings(int n, int[][] b) {
        // If your coordinates range 0..n-1 (zero-based), you can use size = n.
        // If coordinates can be up to n (1-based style) keep n + 1 as in Python.
        int size = n + 1;

        int[] rmax = new int[size];
        int[] rmin = new int[size];
        int[] cmax = new int[size];
        int[] cmin = new int[size];
        // Arrays.fill(rmax, size);
        // Arrays.fill(cmax, size);
        Arrays.fill(cmin, size);
        Arrays.fill(rmin , size);

        // Track extreme buildings for each row and column
        for (int[] point : b) {
            int x = point[0]; // column
            int y = point[1]; // row

            // For row 'y', maintain min and max x
            rmax[y] = Math.max(rmax[y], x);
            rmin[y] = Math.min(rmin[y], x);

            // For column 'x', maintain min and max y
            cmax[x] = Math.max(cmax[x], y);
            cmin[x] = Math.min(cmin[x], y);
        }

        int ans = 0;

        // A building is covered only if it's strictly inside both extremes
        for (int[] point : b) {
            int x = point[0];
            int y = point[1];

            if (rmin[y] < x && x < rmax[y] && cmin[x] < y && y < cmax[x]) {
                ans++;
            }
        }

        return ans;
    }
}