import math
class Solution:
    def countTriples(self, n: int) -> int:
        count = 0
        for a in range(1,n+1):
            for b in range(1,n+1):
                c2 = a*a + b*b
                c = int(math.sqrt(c2))
                if c <= n and c*c == c2:
                    count += 1
        return count            
        