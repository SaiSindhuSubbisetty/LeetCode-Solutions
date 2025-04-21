class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long min = 0, max=0;
        long prefix = 0;
        for(int diff : differences) {
            prefix += diff;
            min = Math.min(min, prefix);
            max = Math.max(max, prefix);
        }
        long minX = lower - min;
        long maxX = upper - max;
        return (int) Math.max(0, maxX-minX+1);
        
    }
}