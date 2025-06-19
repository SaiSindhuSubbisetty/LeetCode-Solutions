class Solution {
    public int partitionArray(int[] nums, int k) {
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num < minValue) minValue = num;
            if (num > maxValue) maxValue = num;
        }

        if (maxValue - minValue <= k) return 1;

        int[] frequency = new int[maxValue - minValue + 1];
        for (int num : nums) {
            frequency[num - minValue]++;
        }

        int groupCount = 1;
        int position = k + 1;
        int limit = maxValue - minValue;

        while (position <= limit) {
            while (position <= limit && frequency[position] == 0) {
                position++;
            }
            if (position <= limit) {
                groupCount++;
                position += k + 1;
            }
        }

        return groupCount;
    }
}