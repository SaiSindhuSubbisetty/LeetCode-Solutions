class Solution {
    public int totalWaviness(int num1, int num2) {
        int total = 0;

        for (int n = num1; n <= num2; n++) {
            char[] d = String.valueOf(n).toCharArray();

            for (int i = 1; i < d.length - 1; i++) {
                if ((d[i] > d[i - 1] && d[i] > d[i + 1]) ||
                    (d[i] < d[i - 1] && d[i] < d[i + 1])) {
                    total++;
                }
            }
        }

        return total;
    }
}