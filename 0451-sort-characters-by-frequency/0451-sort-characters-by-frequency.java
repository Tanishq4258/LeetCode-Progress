class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        PriorityQueue pq = new PriorityQueue<>((a,b) -> map.get(b)-map.get(a));

        pq.addAll(map.keySet());

        StringBuilder st = new StringBuilder();
        while(!pq.isEmpty()){
            char curr = (char)pq.poll();
            int count = map.get(curr);

            for (int i=0;i<count;i++){
                st.append(curr);
            }
        }

        return st.toString();
    }
}