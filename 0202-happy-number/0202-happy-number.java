class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> seenNumbers = new HashSet<>();
        while(n!=1 && !seenNumbers.contains(n))
        {
            seenNumbers.add(n);
            n = getSumOfDigits(n);
        }
        return n==1;
        
    }
    private int getSumOfDigits(int n)
    {
        int sum = 0;
        while(n > 0)
        {
            int digit = n%10;
            sum += digit * digit;
            n /=10;
        }
        return sum;
    }
}