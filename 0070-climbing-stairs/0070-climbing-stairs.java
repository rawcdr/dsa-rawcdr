class Solution {
    public int climbStairs(int n) {
        if (n == 1 || n == 2) return n;

        int d[] = new int[n+1];
        Arrays.fill(d, -1);
        d[1] = 1; d[2] = 2;

        return dp(d, n);
    }

    private int dp(int d[], int n) {
        if(d[n] != -1) return d[n];

        d[n] = dp(d, n-1) + dp(d, n-2);

        return d[n];
    }
}