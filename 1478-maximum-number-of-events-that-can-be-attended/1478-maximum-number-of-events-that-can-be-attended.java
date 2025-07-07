import java.util.*;

class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        int i = 0, n = events.length, res = 0;
        int lastDay = 0;
        for (int[] event : events) {
            lastDay = Math.max(lastDay, event[1]);
        }
        
        for (int day = 1; day <= lastDay; day++) {
            // Add all events starting today
            while (i < n && events[i][0] == day) {
                pq.offer(events[i][1]);
                i++;
            }
            
            // Remove expired events
            while (!pq.isEmpty() && pq.peek() < day) {
                pq.poll();
            }
            
            // Attend one event that ends earliest
            if (!pq.isEmpty()) {
                pq.poll();
                res++;
            }
        }
        
        return res;
    }
}
