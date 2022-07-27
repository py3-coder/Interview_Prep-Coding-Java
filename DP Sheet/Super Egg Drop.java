/*
887. Super Egg Drop
Hard
Share
You are given k identical eggs and you have access to a building with n floors labeled from 1 to n.
You know that there exists a floor f where 0 <= f <= n such that any egg dropped at a floor higher than f will break, 
and any egg dropped at or below floor f will not break.
Each move, you may take an unbroken egg and drop it from any floor x (where 1 <= x <= n). 
If the egg breaks, you can no longer use it. However, 
if the egg does not break, you may reuse it in future moves.
Return the minimum number of moves that you need to determine with certainty what the value of f is.

Example 1:
Input: k = 1, n = 2
Output: 2
Explanation: 
Drop the egg from floor 1. If it breaks, we know that f = 0.
Otherwise, drop the egg from floor 2. If it breaks, we know that f = 1.
If it does not break, then we know f = 2.
Hence, we need at minimum 2 moves to determine with certainty what the value of f is.

Example 2:
Input: k = 2, n = 6
Output: 3

Example 3:
Input: k = 3, n = 14
Output: 4
 

Constraints:

1 <= k <= 100
1 <= n <= 104


*/
class Solution {
    //Recursive Approch.
    public int solveR(int e, int f){
         if(f==0 || f==1){                   //Base case
             return f;
         }
        if(e==1){                           //Base case
            return f;
        }
        int min=Integer.MAX_VALUE;
        for(int i=1;i<f;i++){              //iterate floor by floor till last floor.
            int temp = 1+ Math.max(solveR(e-1,i-1),solveR(e,f-i));  // Maximum of worst
            min = Math.min(temp,min);    //Minimum of worst..
        }
        return min;             //return min..
    }
    //Time Complexity: O(n * (2^min(n,k))
    //Space Complexity: O(1) , If we ignore space taken by stack frame
    // Result TLE------
    
    // Recursion+Memory ->Memoziation 
    public int solveM(int e, int f,int dp[][]){
         if(f==0 || f==1){         //Base case  when floor is 0 or 1 
             return f;
         }
        if(e==1){                  //Base case egg is 1;
            return f;
        }
        if(dp[e][f] !=-1){         //Check wheather its value is available i.e it was previously recursively called on not?
            return dp[e][f];
        }
        int min=Integer.MAX_VALUE; // to store min
        for(int i=1;i<=f;i++){      // drop the egg form 1st floor to floor f
            int temp = 1+ Math.max(solveM(e-1,i-1,dp),solveM(e,f-i,dp)); // Find the max of both case i.e Max of worst 
            min = Math.min(temp,min);                                // min of best cases 
        }
        return dp[e][f]=min;   // update the value in dp[][] and return it.
    }
    //Time Complexity: O((n^2) * k)
    //Space Complexity: O(k * n)
    //Result TLE
    
    // Ierative+Memeory -> Tabulation
    public int solveTab(int e, int f,int dp[][]){
         for(int i=1;i<=f;i++){
             for(int j=1;j<=e;j++){
                 if(i==1){
                     dp[i][j] =j;
                 }else if(j==1){
                     dp[i][j] =1;
                 }else{
                      int min=Integer.MAX_VALUE;
                     for(int mj=j-1,pj=0;mj>=0;mj--,pj++){
                         int val1 =dp[i][mj];
                         int val2 =dp[i-1][pj];
                         int max =Math.max(val1,val2);
                         min =Math.min(max,min);
                     }
                     dp[i][j]=min+1;
                 }
             }
         }
        return dp[f][e];
    }
    //
    
    
    
    public int superEggDrop(int k, int n) {
        //return solveR(k,n);
        int dp[][] = new int[n+1][k+1];
        //for(int i=0;i<dp.length;i++){
        //    for(int j=0;j<dp[0].length;j++){
         //       dp[i][j] =-1;
          //  }
        //}
       // return solveM(k,n,dp);
        return solveTab(k,n,dp);
    }
}
