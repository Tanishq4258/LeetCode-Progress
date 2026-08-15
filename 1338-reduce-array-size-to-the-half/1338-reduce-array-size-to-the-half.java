class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int num: arr){
            freq.put(num, freq.getOrDefault(num, 0)+1);
        }
        List<Integer> freqs = new ArrayList<>(freq.values());
        freqs.sort(Collections.reverseOrder());

        int rem=0, setsize=0;
        int target = arr.length/2;

        for(int i:freqs){
            rem += i;
            setsize++;
            if(rem>=target){
                break;
            }
        }
        return setsize;

    }
}