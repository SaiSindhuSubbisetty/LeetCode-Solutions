class Solution {

    List<Integer> order = new ArrayList<>();
    boolean hasCycle = false;

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // b -> a
        for (int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]);
        }

        int[] state = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {

            if (state[i] == 0) {
                dfs(i, graph, state);
            }

            if (hasCycle) {
                return new int[0];
            }
        }

        Collections.reverse(order);

        int[] result = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            result[i] = order.get(i);
        }

        return result;
    }

    private void dfs(int node,
                     List<List<Integer>> graph,
                     int[] state) {

        if (state[node] == 1) {
            hasCycle = true;
            return;
        }

        if (state[node] == 2) {
            return;
        }

        state[node] = 1; // visiting

        for (int next : graph.get(node)) {
            dfs(next, graph, state);

            if (hasCycle) {
                return;
            }
        }

        state[node] = 2; // visited

        order.add(node);
    }
}