class Solution {
    public int maxJump(int[] stones) {
        int maxjump = stones[1] - stones[0];
        for(int i=2;i<stones.length;i++){
            maxjump = Math.max(maxjump, stones[i]-stones[i-2]);
        }
        return maxjump;
    }
}