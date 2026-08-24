class Solution {
    public String smallestSubsequence(String s) {
        Stack<Character> st = new Stack<>();
        boolean[] used = new boolean[26];
        int[] last = new int[26];
        for(int i = 0;i<s.length();i++){
            last[s.charAt(i)-'a'] = i;
        }
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            if(used[ch-'a']){
                continue;
            }
            while(!st.isEmpty() && st.peek()>ch && last[st.peek()-'a']>i){
                char removed = st.pop();
                used[removed-'a'] = false;
            }
            st.push(ch);
            used[ch-'a'] = true;
        }
        StringBuilder result = new StringBuilder();
        while(!st.isEmpty()){
            result.append(st.pop());
        }
        return result.reverse().toString();
    }
}