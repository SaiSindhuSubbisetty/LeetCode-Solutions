class Solution {
    public String finalString(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        boolean reversed = false;

        for(char ch:s.toCharArray()){
            if(ch == 'i'){
                reversed = !reversed;
            }
            else{
                if(!reversed){
                    deque.addLast(ch);
                }
                else{
                    deque.addFirst(ch);
                }
            }

        }
        StringBuilder result = new StringBuilder();
        for(char c : deque){
            result.append(c);
        }
        if(reversed){
            result.reverse();
        }
        return result.toString();

    }
}



