class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int leftsum=0, rightsum=0;
        int[] sums = new int[n];
        for(int num: nums){
            rightsum += num;
        }
        for(int i=0;i<n;i++){
            rightsum-=nums[i];
            sums[i] = Math.abs(leftsum - rightsum);
            leftsum+=nums[i];
        }
        return sums;

    }
}