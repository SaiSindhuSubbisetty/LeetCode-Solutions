class Solution {
public:
    int maxValue(vector<vector<int>>& events, int k) {
        int n = events.size();
        
        // Sort events by start time for chronological processing
        sort(events.begin(), events.end());
        
        // Memoization table: dp[i][j] = max value starting from event i with j events remaining
        vector<vector<int>> dp(n + 1, vector<int>(k + 1, -1));
        
        return solve(events, 0, k, dp);
    }
    
private:
    int solve(vector<vector<int>>& events, int idx, int remaining, vector<vector<int>>& dp) {
        // Base cases
        if (idx >= events.size() || remaining == 0) {
            return 0;  // No more events to consider or no capacity left
        }
        
        // Return memoized result if already computed
        if (dp[idx][remaining] != -1) {
            return dp[idx][remaining];
        }
        
        // Option 1: Skip current event - move to next event with same remaining capacity
        int skip = solve(events, idx + 1, remaining, dp);
        
        // Option 2: Attend current event
        int attend = events[idx][2];  // Current event's value
        
        // Find next event that can be attended (starts after current event ends)
        int nextIdx = findNextEvent(events, idx);
        
        // Add maximum value from remaining events after attending current one
        if (nextIdx != -1) {
            attend += solve(events, nextIdx, remaining - 1, dp);
        }
        
        // Take maximum of both options and memoize
        dp[idx][remaining] = max(skip, attend);
        return dp[idx][remaining];
    }
    
    // Binary search to find the first event that starts after events[idx] ends
    int findNextEvent(vector<vector<int>>& events, int idx) {
        int endTime = events[idx][1];  // End time of current event
        int left = idx + 1;
        int right = events.size() - 1;
        int result = -1;
        
        // Binary search for first event with start time > endTime
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (events[mid][0] > endTime) {
                result = mid;      // This could be our answer
                right = mid - 1;   // Look for earlier event
            } else {
                left = mid + 1;    // Current event overlaps, look later
            }
        }
        
        return result;
    }
};