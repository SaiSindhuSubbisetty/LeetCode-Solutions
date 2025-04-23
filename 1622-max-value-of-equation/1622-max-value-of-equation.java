import java.util.*;

public class Solution {

    public int findMaxValueOfEquation(int[][] points, int k) {
        int maxVal = Integer.MIN_VALUE;
        Deque<int[]> deque = new ArrayDeque<>();

        for (int[] point : points) {
            int x = point[0];
            int y = point[1];

            // Remove points where x difference is greater than k
            while (!deque.isEmpty() && x - deque.peekFirst()[0] > k) {
                deque.pollFirst();
            }

            // If valid point in deque, calculate max
            if (!deque.isEmpty()) {
                maxVal = Math.max(maxVal, y + x + deque.peekFirst()[1]);
            }

            // Remove points that are worse than current (y - x)
            while (!deque.isEmpty() && deque.peekLast()[1] <= y - x) {
                deque.pollLast();
            }

            // Add current point (x, y - x)
            deque.offerLast(new int[]{x, y - x});
        }

        return maxVal;
    }
}