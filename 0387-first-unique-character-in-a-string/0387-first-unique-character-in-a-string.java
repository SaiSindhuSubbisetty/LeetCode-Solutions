class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character,Integer> hmap = new LinkedHashMap<>();
        for(char c : s.toCharArray())
        {
            hmap.put(c, hmap.getOrDefault(c, 0) + 1);
        }
        for(int i=0;i<s.length();i++)
        {
            if(hmap.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
        
    }
}