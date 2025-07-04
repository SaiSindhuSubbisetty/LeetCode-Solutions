import java.util.*;

class Solution {
    public String reorganizeString(String s) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        // \U0001f4a1 Added check
        for (int count : countMap.values()) {
            if (count > (s.length() + 1) / 2) {
                return "";
            }
        }

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            maxHeap.offer(new int[]{entry.getValue(), entry.getKey()});
        }

        StringBuilder sb = new StringBuilder();
        int[] prev = new int[]{0, '#'};

        while (!maxHeap.isEmpty()) {
            int[] curr = maxHeap.poll();
            sb.append((char) curr[1]);
            curr[0]--;

            if (prev[0] > 0) {
                maxHeap.offer(prev);
            }
            prev = curr;
        }

        return sb.toString();
    }
}
