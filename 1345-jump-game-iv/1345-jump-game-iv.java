import java.util.*;

class Solution {
    public int minJumps(int[] arr) {
        if (arr.length == 1) return 0;

        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        int n = arr.length;

        // Building the HashMap to store indexes of elements
        for (int i = 0; i < n; i++) {
            hm.computeIfAbsent(arr[i] , k -> new ArrayList<>()).add(i);
        }

        Queue<int[]> q = new LinkedList<>();
        boolean[] vis = new boolean[n];

        q.offer(new int[]{0, arr[0], 0}); // idx, val, jump
        vis[0] = true;

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int idx = temp[0];
            int val = temp[1];
            int jump = temp[2];

            if (idx - 1 >= 0 && !vis[idx - 1]) {
                q.offer(new int[]{idx - 1, arr[idx - 1], jump + 1});
                vis[idx - 1] = true;
            }

            if (idx + 1 < n && !vis[idx + 1]) {
                q.offer(new int[]{idx + 1, arr[idx + 1], jump + 1});
                if (idx + 1 == n - 1) return jump + 1;
                vis[idx + 1] = true;
            }

            // Processing elements with the same value
            if (hm.containsKey(val)) {
                for (int unvisitedIdx : hm.get(val)) {
                    if (!vis[unvisitedIdx]) {
                        q.offer(new int[]{unvisitedIdx, val, jump + 1});
                        if (unvisitedIdx == n - 1) return jump + 1;
                        vis[unvisitedIdx] = true;
                    }
                }
                // Clearing the list for the current value after processing
                hm.remove(val);
            }
        }
        return -1;
    }
}