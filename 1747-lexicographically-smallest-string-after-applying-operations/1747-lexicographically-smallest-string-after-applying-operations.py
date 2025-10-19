class Solution:
       def findLexSmallestString(self, s: str, a: int, b: int) -> str:

        def dfs(s: str) -> str:

            if s in seen: return

            seen.add(s)
            res, odd ='', True

            for ch in s:
                odd^= True
                res+= d[ch] if odd else ch
    
            dfs(res)
            dfs(s[b: ] + s[ :b])


        d, seen = {ch:str((int(ch) + a) % 10
                    ) for ch in digits}, set()

        dfs(s)

        return min(seen)