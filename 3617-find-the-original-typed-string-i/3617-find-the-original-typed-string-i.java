class Solution {
    public int possibleStringCount(String word) {
        int n = word.length();
        int ans = 0;
        for(int i=0;i<n;i++){
            char x = word.charAt(i);
            int prev = i;
            while(i<n && x == word.charAt(i)){
                i++;
            }
            ans += i-prev-1;
            i--;
        }
        return ans+1;
    }
}