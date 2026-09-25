class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res =  new ArrayList<>();
        int slen = s.length(), plen = p.length();

        if(slen < plen) return res;

        Map<Character, Integer> pmap = new HashMap<>();
        Map<Character, Integer> smap = new HashMap<>();

        for(char c: p.toCharArray()){
            pmap.put(c, pmap.getOrDefault(c, 0)+1);
        }
        int left = 0;
        for(int right=0;right<slen;right++){
            char inchar = s.charAt(right);
            smap.put(inchar, smap.getOrDefault(inchar, 0)+1);
            if(right - left + 1> plen){
                char outchar = s.charAt(left);
                if(smap.get(outchar)==1){
                    smap.remove(outchar);
                }else{
                    smap.put(outchar, smap.get(outchar) -1);
                }
                left++;
            }
            if(right - left + 1 == plen && smap.equals(pmap)){
                res.add(left);
            }
        }
        return res;
    }
}