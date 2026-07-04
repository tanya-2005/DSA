class Solution {

    public int solve(int[] cost, int[] dp, int i){
        if(i >= cost.length){
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }

        dp[i] = cost[i] + Math.min(solve(cost, dp, i+1), solve(cost, dp, i+2));

        return dp[i];
    }

    public int solveTab(int[]cost, int n){
        int dp[] = new int[n+1];
        dp[n] = 0;
        for(int i = 0; i < n+1; i++){
            dp[i] = cost[i] + Math.min(dp[i+1], dp[i+2]);
        } 

        return Math.min(dp[0], dp[1]);
    }

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);

        return Math.min(solve(cost, dp, 0), solve(cost, dp, 1));
        
    }



    
}