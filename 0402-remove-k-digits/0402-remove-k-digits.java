class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        if(k==n) return "0";

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            char digit = num.charAt(i);
            while(k>0 && sb.length() > 0 && sb.charAt(sb.length()-1)>digit){
                sb.deleteCharAt(sb.length() - 1);
                k--;
            }
            sb.append(digit);
        }
        while(k>0 && sb.length()>0){
            sb.deleteCharAt(sb.length()-1);
            k--;
        }
        int i=0;
        while(i<sb.length() && sb.charAt(i)=='0'){
            i++;
        }
        String res = sb.substring(i);
        return res.isEmpty() ? "0":res;
    }
}