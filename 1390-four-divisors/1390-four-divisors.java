class Solution {
    private int divSumFour(int n) {
        int sum = 0, cnt = 0;
        for (int i = 1; (long)i * i <= n; i++) {
            if (n % i != 0) 
                continue;
            cnt++;
            sum += i;
            int other = n / i;
            if (other != i) {
                cnt++;
                sum += other;
            }
            if (cnt > 4) 
                return 0;
        }
        return (cnt == 4) ? sum : 0;
    }

    public int sumFourDivisors(int[] nums) {
        int res = 0;
        for (int n : nums) {
            res += divSumFour(n);
        }
        return res;
    }
}