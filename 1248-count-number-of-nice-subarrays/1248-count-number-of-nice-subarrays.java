class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k-1);
    }
    private int atMost(int[] nums, int goal){
        if(goal<0) return 0;
        int count = 0, l=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] % 2 != 0){
                goal--;
            }
            while(goal < 0){
                if(nums[l] % 2 != 0){
                    goal++;
                }
                l++;
            }
            count += i-l+1;
        }
        return count;
    }
}