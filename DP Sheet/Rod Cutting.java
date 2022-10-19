/*
Level : Medium
Link :https://practice.geeksforgeeks.org/problems/rod-cutting0840/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
Rod Cutting
Given a rod of length N inches and an array of prices, price[]. pricei denotes the value of a piece of length i. Determine the maximum value obtainable by cutting up the rod and selling the pieces.

Example 1:

Input:
N = 8
Price[] = {1, 5, 8, 9, 10, 17, 17, 20}
Output:
22
Explanation:
The maximum obtainable value is 22 by
cutting in two pieces of lengths 2 and 
6, i.e., 5+17=22.
Example 2:

Input:
N=8
Price[] = {3, 5, 8, 9, 10, 17, 17, 20}
Output: 24
Explanation: 
The maximum obtainable value is 
24 by cutting the rod into 8 pieces 
of length 1, i.e, 8*3=24. 

Your Task:  
You don't need to read input or print anything. Your task is to complete the function cutRod() which takes the array A[] and its size N as inputs and returns the maximum price obtainable.


Expected Time Complexity: O(N2)
Expected Auxiliary Space: O(N)


Constraints:
1 ≤ N ≤ 1000
1 ≤ Ai ≤ 105
*/
class Solution{
    public int cutRod(int price[], int n) {
        //code here
        int len[] = new int[n];
        for(int i=0;i<n;i++)
        len[i] =i+1;
        //Recursion
        //return cutRod_R(price,len,n,n);
        //memo
        //int dp[][] = new int[n+1][n+1];
        //Arrays.stream(dp).forEach(a->Arrays.fill(a,-1));
        //return cutRod_M(price,len,n,n,dp);
        //Tabu
        return cutRod_Tabulation(price,len,n);
        
    }
    //Recursion 
    public static int cutRod_R(int price[],int len[],int n,int L){
    if(L==0 || n==0) return 0;
    if(len[n-1]>L){
        return cutRod_R(price,len,n-1,L);
    }else{
        return Math.max(cutRod_R(price,len,n-1,L),price[n-1]+cutRod_R(price,len,n,L-len[n-1]));
        }
    }
    // Memoization
    public static int cutRod_M(int price[],int len[],int n,int L,int dp[][]){
    if(L==0 || n==0) return 0;
    if(dp[n][L]!=-1) return dp[n][L];
    if(len[n-1]>L){
        return dp[n][L]=cutRod_M(price,len,n-1,L,dp);
    }else{
        return dp[n][L]=Math.max(cutRod_M(price,len,n-1,L,dp),price[n-1]+cutRod_M(price,len,n,L-len[n-1],dp));
        }
    }
    //Tabulation
    public static int cutRod_Tabulation(int price[],int len[],int n){
        
        int dp[][] = new int[n+1][n+1];
        
        for(int i=1;i<n+1;i++){
            for(int j=1;j<n+1;j++){
                if(len[i-1]>j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],price[i-1]+dp[i][j-len[i-1]]);
                }
            }
        }
        return dp[n][n];
    }
}
