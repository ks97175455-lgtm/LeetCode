class Solution {
    public int climbStairs(int n, int[] costs) {
        final long INF = Long.MAX_VALUE / 4;
        long[] dp = new long[n + 1];
        java.util.Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            long stepCost = costs[i - 1]; // costs is 1-indexed in problem, 0-indexed in Java
            for (int jump = 1; jump <= 3 && i - jump >= 0; jump++) {
                long cand = dp[i - jump] + stepCost + (long) jump * jump;
                if (cand < dp[i]) dp[i] = cand;
            }
        }

        return (int) dp[n];
    }
}