class Solution {
    public int largestAltitude(int[] gain) {
        int altitude = 0;
        int maxAltitude = 0;
        for(int g:gain)
        {
            altitude = altitude + g;
            maxAltitude = Math.max(altitude,maxAltitude);
        }
        return maxAltitude;
    }
}