class Solution {
    public int numTilePossibilities(String tiles) {
        int[] freq = new int[26];
        for(int i=0;i<tiles.length();i++){
            freq[tiles.charAt(i)-'A']++;
        }
        return backtrack(freq);
    }
    public int backtrack(int[] freq){
        int c= 0;
        for(int i=0;i<26;i++){
            if(freq[i]==0){
                continue;
            }
            c++;
            freq[i]--;
            c+=backtrack(freq);
            freq[i]++;
        }
        return c;
    }
}