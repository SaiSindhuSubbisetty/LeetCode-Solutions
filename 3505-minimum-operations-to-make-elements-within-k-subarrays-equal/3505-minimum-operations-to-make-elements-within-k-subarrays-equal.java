
import java.util.*;

class Solution {

    static class MedianWindow {
        TreeMap<Integer, Integer> left = new TreeMap<>();
        TreeMap<Integer, Integer> right = new TreeMap<>();

        int leftSize = 0, rightSize = 0;
        long leftSum = 0, rightSum = 0;

        void addToMap(TreeMap<Integer, Integer> map, int num) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        void removeFromMap(TreeMap<Integer, Integer> map, int num) {
            int count = map.get(num);

            if (count == 1) {
                map.remove(num);
            } else {
                map.put(num, count - 1);
            }
        }

        void add(int num) {
            if (leftSize == 0 || num <= left.lastKey()) {
                addToMap(left, num);
                leftSize++;
                leftSum += num;
            } else {
                addToMap(right, num);
                rightSize++;
                rightSum += num;
            }

            balance();
        }

        void remove(int num) {
            if (left.containsKey(num)) {
                removeFromMap(left, num);
                leftSize--;
                leftSum -= num;
            } else {
                removeFromMap(right, num);
                rightSize--;
                rightSum -= num;
            }

            balance();
        }

        void balance() {
            // Left should contain the same number of
            // elements as right, or one extra element.

            while (leftSize > rightSize + 1) {
                int num = left.lastKey();

                removeFromMap(left, num);
                leftSize--;
                leftSum -= num;

                addToMap(right, num);
                rightSize++;
                rightSum += num;
            }

            while (leftSize < rightSize) {
                int num = right.firstKey();

                removeFromMap(right, num);
                rightSize--;
                rightSum -= num;

                addToMap(left, num);
                leftSize++;
                leftSum += num;
            }
        }

        long getCost() {
            long median = left.lastKey();

            long leftCost = median * leftSize - leftSum;
            long rightCost = rightSum - median * rightSize;

            return leftCost + rightCost;
        }
    }

    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;

        // Step 1: Find the cost of every window of size x
        long[] cost = new long[n - x + 1];
        MedianWindow window = new MedianWindow();

        for (int i = 0; i < n; i++) {
            window.add(nums[i]);

            if (i >= x) {
                window.remove(nums[i - x]);
            }

            if (i >= x - 1) {
                cost[i - x + 1] = window.getCost();
            }
        }

        // Step 2: Dynamic programming
        long INF = Long.MAX_VALUE / 4;

        long[] prev = new long[n + 1];

        for (int j = 1; j <= k; j++) {
            long[] curr = new long[n + 1];
            Arrays.fill(curr, INF);

            for (int i = x; i <= n; i++) {
                // Skip the current position
                curr[i] = curr[i - 1];

                // Take a window of size x ending at i - 1
                if (prev[i - x] != INF) {
                    long take = prev[i - x] + cost[i - x];

                    curr[i] = Math.min(curr[i], take);
                }
            }

            prev = curr;
        }

        return prev[n];
    }
}
