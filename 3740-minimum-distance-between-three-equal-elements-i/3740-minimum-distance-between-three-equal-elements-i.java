import java.util.*;

class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        if (n < 3) return -1;

        Map<Integer, List<Integer>> map = new HashMap<>();
        int minDist = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);

            List<Integer> list = map.get(nums[i]);
            int size = list.size();

            // Check only last 3 occurrences
            if (size >= 3) {
                int i1 = list.get(size - 3);
                int i3 = list.get(size - 1);

                int dist = 2 * (i3 - i1);
                minDist = Math.min(minDist, dist);
            }
        }

        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }
}