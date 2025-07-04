class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> hmap = new HashMap<Character, Integer>();
        hmap.put('I',1);
        hmap.put('V', 5);
        hmap.put('X', 10);
        hmap.put('L', 50);
        hmap.put('C', 100);
        hmap.put('D', 500);
        hmap.put('M', 1000);
        
        int result = 0;
        for(int i=0;i<s.length();i++)
        {
            int value = hmap.get(s.charAt(i));
            if(i<s.length()-1 && value < hmap.get(s.charAt(i+1)))
            {
                result -= value;
            } 
            else{
                result += value;
            }

        }
        return result;
    }
}