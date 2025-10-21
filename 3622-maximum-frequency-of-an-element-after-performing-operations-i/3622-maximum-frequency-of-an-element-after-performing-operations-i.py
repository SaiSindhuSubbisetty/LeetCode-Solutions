class Solution:
    def maxFrequency(self, nums, k, numOperations):
        MAXN = 200005
        freq = [0] * MAXN
        prefixSum = [0] * MAXN

        maxValue = max(nums)
        limit = maxValue + k + 2

        for num in nums:
            freq[num] += 1

        if numOperations == 0:
            return max(freq[:limit])
        else:
            prefixSum[0] = freq[0]
            for i in range(1, limit):
                prefixSum[i] = prefixSum[i - 1] + freq[i]

            best = 0

            for target in range(maxValue + 1):
                left = target - k if target > k else 0
                right = target + k if target + k < limit else limit - 1

                total = prefixSum[right] - (prefixSum[left - 1] if left > 0 else 0)
                changeable = total - freq[target]

                possible = freq[target] + min(numOperations, changeable)
                best = max(best, possible)

            return best