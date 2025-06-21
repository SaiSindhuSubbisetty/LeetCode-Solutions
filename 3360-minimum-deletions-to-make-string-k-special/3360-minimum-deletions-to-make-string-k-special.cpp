class Solution {
public:
    int minimumDeletions(string word, int k) {
        int cha[26]={0};
        for(char ch:word){
            cha[ch-'a']++;
        }
        sort(cha,cha+26);
        int i=0,j=25;
        vector<vector<int>>dp(26,vector<int>(26,-1));
        return minDel(i,j,cha,k,dp);
    }

    int minDel(int i, int j, int cha[], int k, vector<vector<int>>& dp) {
         if (i >= j) return 0;
         if (cha[i] == 0) return minDel(i + 1, j, cha, k, dp);
         if (cha[j] - cha[i] <= k) return 0;
         if (dp[i][j] != -1) return dp[i][j];
         int takeLeft = cha[i] + minDel(i + 1, j, cha, k, dp);
         int takeRight = cha[j] - cha[i] - k + minDel(i, j - 1, cha, k, dp);
         dp[i][j] = min(takeLeft, takeRight);
        return dp[i][j];
    }
};