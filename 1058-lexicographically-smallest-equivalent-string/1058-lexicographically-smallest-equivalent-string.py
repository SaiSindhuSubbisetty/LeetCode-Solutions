class Solution:
    def smallestEquivalentString(self, s1: str, s2: str, baseStr: str) -> str:
        graph = {chr(i): [] for i in range(ord('a'), ord('z') + 1)}
        for i in range(len(s1)):
            c1 = s1[i]
            c2 = s2[i]
            graph[c1].append(c2)
            graph[c2].append(c1)
        
        visited = set()
        minimums = {}
        
        def dfs(from_char, char_list):
            visited.add(from_char)
            char_list.append(from_char)
            for to_char in graph[from_char]:
                if to_char not in visited:
                    dfs(to_char, char_list)
        
        for from_char in graph:
            if from_char not in visited:
                char_list = []
                dfs(from_char, char_list)
                min_char = min(char_list)
                for c in char_list:
                    minimums[c] = min_char
        
        return ''.join(minimums[c] for c in baseStr)