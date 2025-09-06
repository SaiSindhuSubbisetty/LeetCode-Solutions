class Solution {
    // Helper function: total steps required for numbers 1..n
    private long totalSteps(long n) {
        if (n <= 0) return 0;

        long steps = 0;
        long base = 1;    // start of range: 4^k
        int level = 1;    // steps needed for numbers in this range

        while (base <= n) {
            long end = base * 4 - 1;       // end of current [4^k .. 4^(k+1)-1] range
            long right = Math.min(n, end); // cap at n

            long count = right - base + 1; // how many numbers fall in this range
            steps += count * level;        // each needs 'level' steps

            base *= 4; // move to next range
            level++;
        }
        return steps;
    }

    public long minOperations(int[][] queries) {
        long ans = 0;
        for (int[] q : queries) {
            long l = q[0], r = q[1];
            long total = totalSteps(r) - totalSteps(l - 1);
            ans += (total + 1) / 2; // ceil division
        }
        return ans;
    }
}
