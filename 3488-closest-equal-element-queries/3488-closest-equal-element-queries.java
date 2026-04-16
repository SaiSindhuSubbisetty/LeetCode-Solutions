import java.util.*;

class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;

        // Map value -> list of indices
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        // Precompute answer for every index
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        for (List<Integer> list : map.values()) {
            int m = list.size();
            if (m == 1) continue;

            // Traverse each occurrence
            for (int i = 0; i < m; i++) {
                int curr = list.get(i);
                int prev = list.get((i - 1 + m) % m);
                int next = list.get((i + 1) % m);

                int distPrev = Math.min(Math.abs(curr - prev), n - Math.abs(curr - prev));
                int distNext = Math.min(Math.abs(curr - next), n - Math.abs(curr - next));

                ans[curr] = Math.min(distPrev, distNext);
            }
        }

        // Answer queries in O(1)
        List<Integer> res = new ArrayList<>();
        for (int q : queries) {
            res.add(ans[q]);
        }

        return res;
    }
}