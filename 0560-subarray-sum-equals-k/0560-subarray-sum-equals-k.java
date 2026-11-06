class Solution {
    public int subarraySum(int[] nums, int k) {
        int count =0;
        int currSum=0;

        Map<Integer, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0,1);
        for(int n:nums){
            currSum+=n;
            if(prefixMap.containsKey(currSum-k)){
                count+= prefixMap.get(currSum-k);
            }
            prefixMap.put(currSum, prefixMap.getOrDefault(currSum, 0)+1);
        }
        return count;
    }
}