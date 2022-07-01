/*
322. Coin Change
Medium
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.
Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Example 3:

Input: coins = [1], amount = 0
Output: 0

Constraints:

1 <= coins.length <= 12
1 <= coins[i] <= 231 - 1
0 <= amount <= 104
*/
/*
RECURSIVE SOLUTION : TLE in LEET-CODE
*/
class Solution {
    public static int solve(int[] coins,int amount){
        if(amount ==0){
            return 0;
        }
        if(amount<0){
            return Integer.MAX_VALUE;
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<coins.length;i++){
            int coin = solve(coins,amount-coins[i]);
            if(coin !=Integer.MAX_VALUE)
                min = Math.min(min,coin+1);
            }
        return min;
        }
    public int coinChange(int[] coins, int amount) {
        int res = solve(coins,amount);
            if(res == Integer.MAX_VALUE){
                return -1;
        }
        return res;
    }
}
/*
MEMOIZATION : ACCEPTED
*/
class Solution {
    public static int solve(int[] coins , int amount,int dp[]){
        if(amount==0) return 0;
        if(amount<0) return Integer.MAX_VALUE;
        if(dp[amount] !=-1){
            return dp[amount];
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<coins.length;i++){
            int coin =solve(coins,amount-coins[i],dp);
            if(coin !=Integer.MAX_VALUE){
                min = Math.min(min, coin+1);
            }
        }
        dp[amount] = min;
        return dp[amount];
    }
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount+1];
        Arrays.fill(dp, -1);
        int res  = solve(coins,amount,dp);
        return res==Integer.MAX_VALUE?-1:res;
    }
}

