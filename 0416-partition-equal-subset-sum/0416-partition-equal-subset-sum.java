class Solution {

    public boolean solve(int[] nums, int i,  int target, Boolean[][] dp){
        if(target == 0){
            return true;
        }
        if(i == nums.length){
            return false;
        }
        if(dp[i][target] != null){
            return dp[i][target];
        }

        boolean notTake = solve(nums, i+1, target, dp);

        boolean take = false;

        if(nums[i] <= target){
            take = solve(nums, i+1, target - nums[i], dp);
        }

        dp[i][target] = notTake || take;
        return dp[i][target];

    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i = 0; i<nums.length; i++){
            sum += nums[i];
        }
        if(sum % 2 != 0){
            return false;
        } 

        int target = sum/2;
        Boolean dp[][] = new Boolean[nums.length + 1][target + 1];

        return solve(nums, 0, target, dp);
    }
    
}