/*
Coin Change

Given an integer array coins[ ] of size N representing different denominations of currency and an integer sum, find the number of ways you can make sum by using different combinations from coins[ ].  
Note: Assume that you have an infinite supply of each type of coin. 

Example 1:

Input:
sum = 4 , 
N = 3
coins[] = {1,2,3}
Output: 4
Explanation: Four Possible ways are:
{1,1,1,1},{1,1,2},{2,2},{1,3}.

Example 2:

Input:
Sum = 10 , 
N = 4
coins[] ={2,5,3,6}
Output: 5
Explanation: Five Possible ways are:
{2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} 
and {5,5}.

Your Task:
You don't need to read input or print anything. Your task is to complete the function count() which accepts an array coins[ ] its size N and sum as input parameters and returns the number of ways to make change for given sum of money. 


Expected Time Complexity: O(sum*N)
Expected Auxiliary Space: O(sum)


Constraints:
1 <= sum, N <= 103

*/
class Solution {
    public long count(int coins[], int N, int sum) {
        // Recursion Driver Code :
        //return count_R(coins,N-1,sum);
        
        // Memoization Driver Code :
        //long dp[][] = new long[N+1][sum+1];
        //Arrays.stream(dp).forEach(a->Arrays.fill(a,-1));
        //return count_Memo(coins,N-1,sum,dp);
        
        // Tabu Driver
        return count_Tab(coins,sum);
    }
    // Similar to Unbounded knapsack think of --> Count of Subset sum problem just do some modification
    // you will enjoy it..
    
    // Recursion 
    public long count_R(int coins[],int n,int sum){
        if(sum ==0) return 1;
        if(n<0) return 0;
        
        if(coins[n]>sum){
            return count_R(coins,n-1,sum);
        }else{
            return count_R(coins,n-1,sum) + count_R(coins,n,sum-coins[n]);
        }
    }
    
    // Memoization 
    public long count_Memo(int coins[],int n,int sum,long dp[][]){
        if(sum ==0) return 1;
        if(n<0) return 0;
        if(dp[n][sum]!=-1) return dp[n][sum];
        if(coins[n]>sum){
            return dp[n][sum]= count_Memo(coins,n-1,sum,dp);
        }else{
            return dp[n][sum]= count_Memo(coins,n-1,sum,dp) + count_Memo(coins,n,sum-coins[n],dp);
        }
    }
    // Tabulation
    public long count_Tab(int coins[],int sum){
        int n=coins.length;
        long dp[][] = new long[n+1][sum+1];
        for(int i=0;i<n+1;i++){
            dp[i][0] =1;
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
             if(coins[i-1]>j){
                dp[i][j] = dp[i-1][j];
            }else{
                dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[n][sum];
    }
}
