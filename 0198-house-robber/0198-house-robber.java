class Solution {
    // public int rob(int[] nums) {
    //     int n = nums.length;
    //     int dp[] = new int[n + 1];

    //     dp[0] = nums[0];
    //     dp[1] = nums[1];
    //     dp[2] = nums[2] + nums[0];

    //     for (int i = 3; i < n; i++) {
    //         if (i < n) dp[i] = Math.max(dp[i-2], dp[i-3]) + nums[i];
    //         else dp[i] = Math.max(dp[i-2], dp[i-3]);
    //     }

    //     return dp[n];
    // }
    public int rob(int[] nums) {
        int n = nums.length;
        int rob=0;
        int nr=0;
        for(int i:nums){
            int t=rob;
            rob=nr+i;
            nr=Math.max(t,nr);
        }
        return Math.max(rob,nr);
       
    }
}