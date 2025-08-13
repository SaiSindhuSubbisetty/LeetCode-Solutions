class Solution {
     public boolean isPowerOfThreeHelper(int n) {
        if(n<=0) return false;
        if(n == 1) return true;
        if(n%3 != 0) return false;
        return isPowerOfThreeHelper(n/3);
        
    }
    public boolean isPowerOfThree(int n) {
        return isPowerOfThreeHelper(n);
        
    }
}