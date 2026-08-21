class Solution {
    public int balancedStringSplit(String s) {
        int count=0;
        int balanced = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == 'R'){
                balanced++;
            }else{
                balanced--;
            }
            if(balanced == 0){
                count++;
            }
        }
        return count;
    }
}