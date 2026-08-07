class Solution {
    public boolean checkValidString(String s) {
        int open=0, close=0;
        for(char c: s.toCharArray()){
            if(c=='('){
                open++;
                close++;
            }
            else if(c==')'){
                open--;
                close--;
            }else{
                open--;
                close++;
            }
            if(close<0) return false;
            if(open<0) open = 0; 
        }
        return open==0;
    }
}