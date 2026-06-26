class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0"))
        {
            return "0";
        }
        int[] result = new int[num1.length() + num2.length()];
        for(int i=num1.length()-1;i>=0;i--)
        {
            for(int j=num2.length()-1;j>=0;j--)
            {
                int digit1 = num1.charAt(i) - '0';
                int digit2 = num2.charAt(j) - '0';
                int mul = digit1 * digit2;
                int posLow = i+j+1;
                int posHigh = i+j; //carry

                int sum = mul + result[posLow];
                result[posLow] = sum % 10;
                result[posHigh] += sum /10;
            }

        }
        StringBuilder product = new StringBuilder();
        for(int num : result)
        {
            if(!(product.length() == 0 && num == 0))
            {
                product.append(num);
            }
        }
        return product.length() == 0? "0":product.toString();
        
    }
}