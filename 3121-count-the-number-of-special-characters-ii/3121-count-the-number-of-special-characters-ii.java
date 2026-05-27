class Solution {
    public int numberOfSpecialChars(String word) {
        int[] lastLower = new int[26];
        int[] firstUpper = new int[26];

        Arrays.fill(lastLower,-1);
        Arrays.fill(firstUpper,-1);

        for(int i=0;i<word.length();i++)
        {
            char c = word.charAt(i);
            if(Character.isLowerCase(c))
            {
                lastLower[c-'a'] = i;
            }
            else{
                int idx = c-'A';
                if(firstUpper[idx] == -1)
                {
                    firstUpper[idx] = i;
                }
            }

        }
        int count = 0;
        for(int i=0;i<26;i++)
        {
            if(lastLower[i] != -1 && firstUpper[i] != -1 && lastLower[i] < firstUpper[i])
            {
                count++;

            }
        }
        return count;
        
    }
}