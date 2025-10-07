import bisect

class Solution:
    def avoidFlood(self, rains):
        n = len(rains)
        ans = [1] * n  # default value for dry days
        full = {}      # lake -> last day it was filled
        dry_days = []  # sorted list of indices where rains[i] == 0

        for i, lake in enumerate(rains):
            if lake == 0:
                bisect.insort(dry_days, i)  # keep dry_days sorted
            else:
                ans[i] = -1
                if lake in full:
                    # Find the dry day index > last filled day of this lake
                    last_day = full[lake]
                    pos = bisect.bisect_right(dry_days, last_day)
                    if pos == len(dry_days):
                        return []  # No valid dry day -> flood
                    dry_day = dry_days[pos]
                    ans[dry_day] = lake  # dry this lake on that day
                    dry_days.pop(pos)
                full[lake] = i  # mark lake as filled

        return ans
