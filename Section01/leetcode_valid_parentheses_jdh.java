/*
    풀이 시간: 3분
*/
class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();
        
        for(int i = 0; i < s.length(); i++){
            Character ch = s.charAt(i);
            if(!st.empty()){
                Character open = st.peek();
                
                if(open == '(' && ch == ')' || open == '{' && ch == '}' || open == '[' && ch == ']') {
                    st.pop();
                } else {
                    st.push(ch);
                }
            } else st.push(ch);
        }
        
        if(st.size() == 0) return true;
        else return false;
    }
}
