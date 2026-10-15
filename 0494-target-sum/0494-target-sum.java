class Solution {

    public int solve(int[] nums, int target, int i, int sum) {

        if (i == nums.length) {
            if (sum == target) {
                return 1;
            }
            return 0;
        }
        int plus = solve(nums, target, i + 1, sum + nums[i]);
        int minus = solve(nums, target, i + 1, sum - nums[i]);
        return plus + minus;
    }

    public int findTargetSumWays(int[] nums, int target) {
        return solve(nums, target, 0, 0);

    }
}