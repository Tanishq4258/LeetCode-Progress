class Solution {
    public String reorganizeString(String s) {
        int[] count = new int[26];
        int maxcount=0;
        int letter = 0;
        for(int i=0;i<s.length();i++){
            int index = s.charAt(i) -'a';
            count[index]++;
            if(count[index] > maxcount){
                maxcount = count[index];
                letter = index;
            }
        }
        if(maxcount>(s.length()+1)/2){
            return "";
        }
        char[] res = new char[s.length()];
        int index = 0;
        while(count[letter]>0){
            res[index] = (char)(letter+'a');
            index+=2;
            count[letter]--;
        }
        for(int i=0;i<26;i++){
            while(count[i]>0){
                if(index>=res.length){
                    index= 1;
                }
                res[index] = (char)(i+'a');
                index+=2;
                count[i]--;
            }
        }
        return new String(res);
    }
}