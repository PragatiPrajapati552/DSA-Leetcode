class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        int c = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '['){
                st.push(ch);
                c++;
            }
            else{
                if(st.isEmpty())
                return false;
                if ((ch == ')' && st.peek() == '(' ) || (ch == '}' && st.peek() == '{')|| (ch == ']' && st.peek() == '[')){
                st.pop();
                }
                else
                return false;
            
            }
            
        }
        if(c > 0 && st.isEmpty())
        return true;
        else
        return false;
        

    }
}