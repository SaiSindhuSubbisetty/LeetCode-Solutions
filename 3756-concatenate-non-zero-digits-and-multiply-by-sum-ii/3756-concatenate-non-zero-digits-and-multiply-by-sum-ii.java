class Solution {
    static final long MOD = 1_000_000_007L;
    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();
        long[] prefixValue = new long[n];
        int[] prefixSum = new int[n];
        int[] prefixCount = new int[n];
        long[] pow10 = new long[n + 1];
        pow10[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }
        long value = 0;
        int sum = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int d = s.charAt(i) - '0';
            if (d != 0) {
                value = (value * 10 + d) % MOD;
                sum += d;
                count++;
            }
            prefixValue[i] = value;
            prefixSum[i] = sum;
            prefixCount[i] = count;
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            long x;
            int digitSum;
            int len;
            if (l == 0) {
                x = prefixValue[r];
                digitSum = prefixSum[r];
                len = prefixCount[r];
            } else {
                len = prefixCount[r] - prefixCount[l - 1];
                x = (prefixValue[r]
                        - (prefixValue[l - 1] * pow10[len]) % MOD
                        + MOD) % MOD;

                digitSum = prefixSum[r] - prefixSum[l - 1];
            }
            ans[i] = (int) ((x * digitSum) % MOD);
        }
        return ans;
    }
}