class Solution {
    public int coinChange(int[] coins, int amount) {

        if (coins == null || coins.length == 0)
            return 0;

        int[][] dp = new int[coins.length + 1][amount + 1];

        for (int j = 1; j < dp[0].length; j++) {
            dp[0][j] = 9999999;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (coins[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
                }
            }
        }

        int result = dp[dp.length - 1][dp[0].length - 1];
        if (result > 999999)
            return -1;
        return result;

    }
}
