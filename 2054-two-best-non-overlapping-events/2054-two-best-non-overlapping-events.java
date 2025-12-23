import java.util.*;

class Solution {
    public int maxTwoEvents(int[][] events) {
        // Sort events by end time
        Arrays.sort(events, (a, b) -> Integer.compare(a[1], b[1]));

        int n = events.length;

        // maxValueTill[i] = max value among events[0..i]
        int[] maxValueTill = new int[n];
        maxValueTill[0] = events[0][2];

        for (int i = 1; i < n; i++) {
            maxValueTill[i] = Math.max(maxValueTill[i - 1], events[i][2]);
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            int start = events[i][0];
            int value = events[i][2];

            // Option 1: take only this event
            ans = Math.max(ans, value);

            // Option 2: take this + previous non-overlapping event
            int idx = binarySearch(events, start);
            if (idx != -1) {
                ans = Math.max(ans, value + maxValueTill[idx]);
            }
        }

        return ans;
    }

    // Find last event with end < start
    private int binarySearch(int[][] events, int start) {
        int left = 0, right = events.length - 1;
        int res = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (events[mid][1] < start) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}
