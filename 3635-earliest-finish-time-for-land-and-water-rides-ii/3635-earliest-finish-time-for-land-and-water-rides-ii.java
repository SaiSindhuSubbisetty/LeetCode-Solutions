import java.util.*;

class Solution {

    static class Ride {
        int start, dur;
        Ride(int s, int d) {
            start = s;
            dur = d;
        }
    }

    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
                                  int[] waterStartTime, int[] waterDuration) {

        List<Ride> land = build(landStartTime, landDuration);
        List<Ride> water = build(waterStartTime, waterDuration);

        long ans = Long.MAX_VALUE;

        // land -> water
        ans = Math.min(ans, solve(land, water));

        // water -> land
        ans = Math.min(ans, solve(water, land));

        return (int) ans;
    }

    private long solve(List<Ride> A, List<Ride> B) {
        int m = B.size();

        int[] prefMinDur = new int[m];
        int[] sufMinStartPlusDur = new int[m];

        // prefix min duration
        prefMinDur[0] = B.get(0).dur;
        for (int i = 1; i < m; i++) {
            prefMinDur[i] = Math.min(prefMinDur[i - 1], B.get(i).dur);
        }

        // suffix min (start + duration)
        sufMinStartPlusDur[m - 1] = B.get(m - 1).start + B.get(m - 1).dur;
        for (int i = m - 2; i >= 0; i--) {
            sufMinStartPlusDur[i] = Math.min(
                sufMinStartPlusDur[i + 1],
                B.get(i).start + B.get(i).dur
            );
        }

        long res = Long.MAX_VALUE;

        for (Ride a : A) {
            long finishA = (long) a.start + a.dur;

            int idx = upperBound(B, finishA);

            // case 1: start <= finishA
            if (idx >= 0) {
                long bestDur = prefMinDur[idx];
                res = Math.min(res, finishA + bestDur);
            }

            // case 2: start > finishA
            if (idx + 1 < m) {
                res = Math.min(res, sufMinStartPlusDur[idx + 1]);
            }
        }

        return res;
    }

    // first index with start > target
    private int upperBound(List<Ride> arr, long target) {
        int l = 0, r = arr.size() - 1;
        int ans = -1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr.get(mid).start <= target) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    private List<Ride> build(int[] start, int[] dur) {
        List<Ride> list = new ArrayList<>();
        for (int i = 0; i < start.length; i++) {
            list.add(new Ride(start[i], dur[i]));
        }
        list.sort(Comparator.comparingInt(r -> r.start));
        return list;
    }
}