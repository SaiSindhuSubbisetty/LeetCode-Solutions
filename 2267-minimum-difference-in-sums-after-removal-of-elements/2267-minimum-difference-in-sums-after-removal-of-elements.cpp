class Solution {
public:
    long long minimumDifference(vector<int>& nums) {
        int n = nums.size() / 3;
        long ans = LONG_MAX;
        long leftSum = 0, rightSum = 0;

        // max-heap for left part (smallest n values)
        priority_queue<int> maxHeap;
        // min-heap for right part (largest n values)
        priority_queue<int, vector<int>, greater<>> minHeap;

        vector<long> minLeftSum(nums.size());

        for (int i = 0; i < 2 * n; ++i) {
            maxHeap.push(nums[i]);
            leftSum += nums[i];
            if (maxHeap.size() > n) {
                leftSum -= maxHeap.top();
                maxHeap.pop();
            }
            if (maxHeap.size() == n)
                minLeftSum[i] = leftSum;
        }

        for (int i = nums.size() - 1; i >= n; --i) {
            minHeap.push(nums[i]);
            rightSum += nums[i];
            if (minHeap.size() > n) {
                rightSum -= minHeap.top();
                minHeap.pop();
            }
            if (minHeap.size() == n)
                ans = min(ans, minLeftSum[i - 1] - rightSum);
        }

        return ans;
    }
};