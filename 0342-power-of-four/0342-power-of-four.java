class Solution {
    public boolean isPowerOfFourHelper(int n) {
        if(n <= 0) return false;
        if(n == 1) return true;
        if(n % 4 != 0) return false;
        return isPowerOfFour(n/4);
        
        
    }
    public boolean isPowerOfFour(int n) {
        return isPowerOfFourHelper(n);

        
    }
}