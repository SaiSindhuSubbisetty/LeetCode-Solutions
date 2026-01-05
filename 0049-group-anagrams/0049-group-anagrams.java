class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0){
            return new ArrayList<>();
        }
        Map<String, List<String>> frequencyStringMap = new HashMap<>();

        for(String str : strs){
            String frequencyString = getFrequencyString(str);
            if(frequencyStringMap.containsKey(frequencyString)){
                frequencyStringMap.get(frequencyString).add(str);
            }
            else{
                List<String> strlist = new ArrayList<>();
                strlist.add(str);
                frequencyStringMap.put(frequencyString, strlist);
            }
        }
        return new ArrayList<>(frequencyStringMap.values());
    }
    private String getFrequencyString(String str){
        int[] freq = new int[26];

        for(char c : str.toCharArray()){
            freq[c-'a']++;
        }

        StringBuilder frequencyString = new StringBuilder("");
        char c = 'a';
        for(int i : freq)
        {
            frequencyString.append(c);
            frequencyString.append(i);
            c++;
        }
        return frequencyString.toString();
    }
}