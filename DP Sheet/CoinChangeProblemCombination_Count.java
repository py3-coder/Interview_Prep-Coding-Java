/*
Input : [2]
         3
OutPut : 0 
Exp.:To make amount 3 using coins 2 is not possible so it return 0.

Input:[1,2,5]
amount : 11
OutPut :11
Exp.: To make amount 11 using coins 1,2,5 is 11 ways by which we can make amount 11.
*/

class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[]  = new int[amount+1];
        dp[0] =1;
        for(int i=0;i<coins.length;i++){
            for(int j=coins[i];j<dp.length;j++){
                dp[j] += dp[j-coins[i]];
            }
        }
        for(int i=0;i<amount+1;i++){
        System.out.println(dp[i]);
        }
        return dp[amount];
    }
}
