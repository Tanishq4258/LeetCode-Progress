class Solution {
    public void reverseString(char[] s) {
        func(s, 0, s.length-1);

    }
    public void func(char[] s, int left, int right){
        if(left>=right) return;
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
        func(s, left+1, right-1);
    }
}