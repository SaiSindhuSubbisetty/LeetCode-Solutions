class Solution {
    public int binaryGap(int n) {
        int maxGap = 0;
        int currentGap = -1;

        while (n != 0) {
            if ((n & 1) == 1) {
                if (currentGap != -1) {
                    maxGap = Math.max(maxGap, currentGap);
                }
                currentGap = 1;
            } else {
                if (currentGap != -1) {
                    currentGap++;
                }
            }
            n >>= 1;
        }

        return maxGap;
    }
}