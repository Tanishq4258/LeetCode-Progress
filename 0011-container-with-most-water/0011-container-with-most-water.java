class Solution {
    public int maxArea(int[] height) {
        int left=0;
        int right=height.length - 1;
        int maxWater = 0;

        while(left<right){
            int currH = Math.min(height[left], height[right]);
            int currW = right-left;
            int currA = currH*currW;
            maxWater = Math.max(maxWater, currA);

            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxWater;
    }
}