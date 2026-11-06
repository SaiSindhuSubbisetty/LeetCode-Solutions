
import java.util.Arrays;

class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {

        // 1. Sort request logs by time
        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));

        int q = queries.length;
        int m = logs.length;

        // 2. Save query time and original position
        int[][] sortedQueries = new int[q][2];

        for (int i = 0; i < q; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }

        Arrays.sort(sortedQueries,
            (a, b) -> Integer.compare(a[0], b[0]));

        // 3. Count requests per server
        int[] freq = new int[n + 1];
        int[] answer = new int[q];

        int left = 0;
        int right = 0;
        int activeServers = 0;

        // 4. Process each query
        for (int[] query : sortedQueries) {

            int time = query[0];
            int originalIndex = query[1];

            // Add requests up to this query time
            while (right < m && logs[right][1] <= time) {

                int server = logs[right][0];

                if (freq[server] == 0) {
                    activeServers++;
                }

                freq[server]++;
                right++;
            }

            // Remove requests older than the interval
            while (left < right && logs[left][1] < time - x) {

                int server = logs[left][0];

                freq[server]--;

                if (freq[server] == 0) {
                    activeServers--;
                }

                left++;
            }

            // Find number of inactive servers
            answer[originalIndex] = n - activeServers;
        }

        return answer;
    }
}
