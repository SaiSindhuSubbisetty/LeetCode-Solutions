class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        int start = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == key) {
                int left = Math.max(0, i - k);
                int right = Math.min(n - 1, i + k);

                while (start <= right) {
                    if (start >= left) {
                        result.add(start);
                    }
                    start++;
                }
            }
        }

        return result;
    }
}