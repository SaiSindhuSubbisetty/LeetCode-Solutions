class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        
        StringBuilder result = new StringBuilder();
        
        // handle sign
        if ((numerator < 0) ^ (denominator < 0)) {
            result.append("-");
        }
        
        // convert to long to avoid overflow
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        
        // integer part
        result.append(num / den);
        long remainder = num % den;
        if (remainder == 0) return result.toString();
        
        result.append(".");
        
        // fractional part
        Map<Long, Integer> map = new HashMap<>();
        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                result.insert(map.get(remainder), "(");
                result.append(")");
                break;
            }
            map.put(remainder, result.length());
            remainder *= 10;
            result.append(remainder / den);
            remainder %= den;
        }
        
        return result.toString();
    }
}
