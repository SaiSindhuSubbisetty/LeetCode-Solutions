import java.util.Stack.*;
import java.util.*;
class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(Character c : s.toCharArray())
        {
            if(c == '(' || c=='{' || c=='['){
                st.push(c);
            }
            else{
                if(st.isEmpty()) return false;
                char top = st.pop();
                if((top == '(' && c != ')') || 
                   (top == '{' && c != '}') ||
                   (top == '[' && c != ']')
                ){
                    return false;

                }
            }
        }
        return st.isEmpty();
    }
}

//TC:0(n)
//Sc:0(n)
