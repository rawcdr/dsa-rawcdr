class Solution {
    int nn=0;
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        nn=n;

        dp[0] = cost[0];
        dp[1] = cost[1];

        return rec(dp, cost, n);
    }

    private int rec(int[] dp, int[] cost, int n) {
        if (dp[n] != -1) return dp[n];
        if (n < nn) dp[n] = Math.min(rec(dp, cost, n-1), rec(dp, cost, n-2)) +cost[n];
        else dp[n] = Math.min(rec(dp, cost, n-1), rec(dp, cost, n-2));
        return dp[n];
    }
}