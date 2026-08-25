class Solution {
    public int longestPalindrome(String s) {
        int[] freq = new int[128];
        for(char ch: s.toCharArray()){
            freq[ch]++;
        }
        int l=0;
        boolean odd = false;

        for(int count: freq){
            l+=(count/2) *2;
            if(count%2 == 1){
                odd = true;
            }
        }
        return odd? l+1: l;
    }
}