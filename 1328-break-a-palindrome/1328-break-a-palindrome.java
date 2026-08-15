class Solution {
    public String breakPalindrome(String palindrome) {
        if(palindrome.length() <= 1) return "";
        StringBuilder res = new StringBuilder(palindrome);
        
        for(int i=0;i<palindrome.length() / 2; i++){
            if (res.charAt(i) != 'a') {
                res.setCharAt(i, 'a');
                return res.toString();
            }
        }
        res.setCharAt(palindrome.length() - 1, 'b');
        return res.toString();
    }
}