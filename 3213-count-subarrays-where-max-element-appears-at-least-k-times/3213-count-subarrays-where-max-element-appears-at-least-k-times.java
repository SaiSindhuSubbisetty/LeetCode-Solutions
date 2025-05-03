public class Solution {
    public long countSubarrays(int[] nums, int k) {
        int target = 0;
        for (int num : nums) {
            target = Math.max(target, num);
        }

        long res = 0;
        int n = nums.length;
        int left = 0;
        int count = 0; // count of target in current window

        for (int right = 0; right < n; right++) {
            if (nums[right] == target) {
                count++;
            }

            while (count >= k) {
                // all subarrays from left to end are valid
                res += (n - right);

                if (nums[left] == target) {
                    count--;
                }
                left++;
            }
        }

        return res;
    }
}
