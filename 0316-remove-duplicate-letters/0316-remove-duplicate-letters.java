class Solution {
    public String removeDuplicateLetters(String s) {
        int[] lastindex = new int[26];
        for(int i=0;i<s.length();i++){
            lastindex[s.charAt(i) - 'a'] = i;
        }
        boolean[] seen = new boolean[26];
        Deque<Character> stack = new ArrayDeque<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(seen[c-'a']){
                continue;
            }
            while(!stack.isEmpty() && stack.peek()>c && lastindex[stack.peek() - 'a']>i){
                seen[stack.pop() - 'a'] = false;
            }
            stack.push(c);
            seen[c-'a'] = true;
        }
        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()){
            res.append(stack.pop());
        }
        return res.reverse().toString();
    }
}