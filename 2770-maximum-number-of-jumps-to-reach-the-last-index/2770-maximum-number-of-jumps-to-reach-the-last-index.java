class Solution {
    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        // dp[i] = max jumps to reach i; -1 = unreachable
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            // skip unreachable index
            if (dp[i] == -1) continue;

            for (int j = i + 1; j < n; j++) {
                // valid jump condition
                if (Math.abs(nums[j] - nums[i]) <= target)
                    dp[j] = Math.max(dp[j], dp[i] + 1);
            }
        }

        return dp[n - 1];
    }
}