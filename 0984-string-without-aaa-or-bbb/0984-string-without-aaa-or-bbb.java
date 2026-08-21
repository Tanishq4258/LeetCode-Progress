class Solution {
    public String strWithout3a3b(int a, int b) {
        StringBuilder sb = new StringBuilder();
        while(a>0 || b>0){
            int l = sb.length();
            boolean writeA = false;

            if(l>=2&&sb.charAt(l - 1) == sb.charAt(l-2)){
                if(sb.charAt(l-1)=='b'){
                    writeA = true;
                }
            }else{
                if(a>=b){
                    writeA = true;
                }
            }
            if(writeA){
               sb.append('a');
                a--;
            }else{
                sb.append('b');
                b--;
            }
        }
        return sb.toString();
    }
    
}