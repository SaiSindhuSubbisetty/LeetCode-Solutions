class Solution {
public:
    long long mostPoints(vector<vector<int>>& questions) {
        int n = questions.size();
        vector<long long> dp(n + 1, 0);
        for (int i = n - 1; i >= 0; --i) {
            int point = questions[i][0], brainpower = questions[i][1];
            long long solve = point + (i + brainpower + 1 <= n ? dp[i + brainpower + 1] : 0);
            dp[i] = max(dp[i + 1], solve);
        }
        return dp[0];
    }
};