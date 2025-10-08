from bisect import bisect_left
from typing import List
class Solution:
    def successfulPairs(self, spells: List[int], potions: List[int], success: int) -> List[int]:
        potions.sort()
        m = len(potions)
        ans  = []
        for s in spells:
            need = (success + s - 1) // s
            pos = bisect_left(potions, need)
            ans.append(m - pos)
        return ans    