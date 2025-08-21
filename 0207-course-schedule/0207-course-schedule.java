class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<numCourses;i++)
        {
            graph.add(new ArrayList<>());
        }

        for(int[] pre : prerequisites)
        {
            graph.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;

        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++)
        {
            if(indegree[i] == 0)
            {
                queue.add(i);
            }
        }
        int count = 0;
        while(!queue.isEmpty())
        {
            int course = queue.poll();
            count++;
            for(int next : graph.get(course)){
                indegree[next]--;
                if(indegree[next] == 0)
                {
                    queue.add(next);
                }
            }
        }
        return count == numCourses;
        
    }
}