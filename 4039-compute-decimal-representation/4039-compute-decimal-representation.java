import java.util.*;

class Solution {
    public int[] decimalRepresentation(int n) {
        List<Integer> components = new ArrayList<>();
        int base = 1;

        while (n > 0) {
            int digit = n % 10;
            if (digit != 0) {
                components.add(digit * base);
            }
            n /= 10;
            base *= 10;
        }

        Collections.reverse(components);

        int[] result = new int[components.size()];
        for (int i = 0; i < components.size(); i++) {
            result[i] = components.get(i);
        }
        return result;
    }
}
