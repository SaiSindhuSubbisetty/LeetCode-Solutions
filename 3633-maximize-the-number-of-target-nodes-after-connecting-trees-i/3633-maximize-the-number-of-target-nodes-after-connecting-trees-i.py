class Solution:
    def maxTargetNodes(self, edges1: List[List[int]], edges2: List[List[int]], k: int) -> List[int]:

        def build_graph(edges):
            graph = [[] for _ in range(len(edges)+1)]
            for u, v in edges:
                graph[u].append(v)
                graph[v].append(u)
            return graph

        def dfs(node, parent, k):
            if k == 0:
                return 0
            s = 1
            for neighbor in graph[node]:
                if neighbor != parent:
                    s += dfs(neighbor, node, k-1)
            return s

        graph = build_graph(edges2)
        max_target_node = max(dfs(node, -1, k) for node in range(len(edges2)+1))
        graph = build_graph(edges1)
        return [dfs(node, -1, k+1) + max_target_node for node in range(len(edges1)+1)]