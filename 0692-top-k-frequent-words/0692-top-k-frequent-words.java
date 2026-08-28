class Solution {
    public List<String> topKFrequent(String[] words, int k) {
         Map<String, Integer> countMap = new HashMap<>();
         for(String word: words){
            countMap.put(word, countMap.getOrDefault(word, 0)+1);
         }

         PriorityQueue<String> minheap = new PriorityQueue<>((w1,w2) -> {
            int freq1 = countMap.get(w1);
            int freq2 = countMap.get(w2);
            if(freq1 != freq2){
                return Integer.compare(freq1, freq2);
            }
            return w2.compareTo(w1);
         });

         for(String word: countMap.keySet()){
            minheap.offer(word);
            if(minheap.size() > k){
                minheap.poll();
            }
         }

         List<String> res = new ArrayList<>();
         while(!minheap.isEmpty()){
            res.add(minheap.poll());
         }
         Collections.reverse(res);
         return res;
    }
}