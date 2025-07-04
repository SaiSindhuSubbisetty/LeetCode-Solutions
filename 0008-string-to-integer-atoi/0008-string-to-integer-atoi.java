class Solution {
    public int myAtoi(String s) {
        int i = 0, n = s.length();
        int INT_MAX = Integer.MAX_VALUE;
        int INT_MIN = Integer.MIN_VALUE;

        // Skip whitespaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // Check sign (should be IF and use OR)
        int sign = 1;
        if (i < n && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            sign = s.charAt(i) == '-' ? -1 : 1;
            i++;
        }

        // Read digits
        int num = 0;
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            if (num > (INT_MAX - digit) / 10) {
                return sign == 1 ? INT_MAX : INT_MIN;
            }

            num = num * 10 + digit;
            i++;
        }

        return sign * num;
    }
}
