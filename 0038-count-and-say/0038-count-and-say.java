class Solution {
    public String countAndSay(int n) {
        if(n == 1)
        {
            return "1";
        }
        else if(n == 2)
        {
            return "11";
        }
        String str = "11";
        for(int i = 1; i < n + 1; i++)
        {
            if(i <= 2)
            {
                continue;
            }
            str = count(i, str);
        }

        return str;

    }
    public static String count(int n, String s)
    {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int j = 1; j < s.length(); j++) {
                if (s.charAt(j) == s.charAt(j - 1)) {
                    count++; 
                } else {
                    sb.append(count);
                    sb.append(s.charAt(j - 1));
                    count = 1;
                }
            }
            // for last character
            sb.append(count);
            sb.append(s.charAt(s.length() - 1));

            s = sb.toString();

        return s;
    }
}