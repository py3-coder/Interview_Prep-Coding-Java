/*
LINK PROBLEM : https://www.geeksforgeeks.org/subset-sum-problem-dp-25/
Given a set of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum. 
Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 9
Output: True  
There is a subset (4, 5) with sum 9.

Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 30
Output: False
There is no subset that add up to 30.
*/
//Method 1: Recursion. 
static boolean subsetsum(int[] arr,int sum,int n){
        if(sum==0) return true;
        if(n==0) return false;
        if(arr[n]>sum){
            return subsetsum(arr,sum,n-1);
        }else{
            boolean pick = subsetsum(arr,sum-arr[n],n-1);
            boolean not_pick =subsetsum(arr,sum,n-1);
            
            return (pick||not_pick);
        }
    }

// Method 2: Memoization = Recursion+Memory
  public static boolean subsetsum(int[] arr,int sum,int n,Boolean dp[][]){
        if(sum==0) return true;
        if(n==0) return false;
        if(dp[n][sum]!=null){
            return dp[n][sum];
        }
        if(arr[n]>sum){
            return subsetsum(arr,sum,n-1,dp);
        }else{
            boolean pick = subsetsum(arr,sum-arr[n],n-1,dp);
            boolean not_pick =subsetsum(arr,sum,n-1,dp);
            
            dp[n][sum]=(pick||not_pick);
            return dp[n][sum];
        }
    }
}
// Method 3 : Tabulation ~ TOP_DOWN APPROCH;
    public static boolean subsetsum_tab(int[] arr,int sum,int n){
        boolean dp[][] = new boolean[arr.length+1][sum+1];
        for(int i=0;i<n+1;i++){
            dp[i][0] =true;
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                if(arr[i-1]>j){
                    dp[i][j]= dp[i-1][j];
                }else{
                    dp[i][j]= dp[i-1][j] || dp[i-1][j-arr[i-1]];
                }
            }
        }
        return dp[n][sum];
    }

/*
Complete Solution :
*/

// SUBSET SUM PROBLEM ~ DP (MEDIUM LEVEL)
public class Main
{
	public static void main(String[] args) {
	    int arr[] ={ 3, 34, 4, 12, 5, 2 };
	    int sum =9;
	    int n = arr.length;
	    // boolean res = subsetsum_Recursion(arr,sum,n-1)
	    // System.out.print(res);
	    //Boolean dp[][] = new Boolean[n+1][sum+1];
	    //boolean ans =subsetsum_Memo(arr,sum,n-1,dp);
	    boolean ans =subsetsum_tab(arr,sum,n);
	    System.out.print(ans);
	}
	//Recursion
	static boolean subsetsum_Recursion(int[] arr,int sum,int n){
        if(sum==0) return true;
        if(n==0) return false;
        if(arr[n]>sum){
            return subsetsum_Recursion(arr,sum,n-1);
        }else{
            boolean pick = subsetsum_Recursion(arr,sum-arr[n],n-1);
            boolean not_pick =subsetsum_Recursion(arr,sum,n-1);
            
            return (pick||not_pick);
        }
    }
    //Memoization
	public static boolean subsetsum_Memo(int[] arr,int sum,int n,Boolean dp[][]){
        if(sum==0) return true;
        if(n==0) return false;
        if(dp[n][sum]!=null){
            return dp[n][sum];
        }
        if(arr[n]>sum){
            return subsetsum_Memo(arr,sum,n-1,dp);
        }else{
            boolean pick = subsetsum_Memo(arr,sum-arr[n],n-1,dp);
            boolean not_pick =subsetsum_Memo(arr,sum,n-1,dp);
            
            dp[n][sum]=(pick||not_pick);
            return dp[n][sum];
        }
    }
    // Tabulation ~ TOP_DOWN APPROCH;
    public static boolean subsetsum_tab(int[] arr,int sum,int n){
        boolean dp[][] = new boolean[arr.length+1][sum+1];
        for(int i=0;i<n+1;i++){
            dp[i][0] =true;
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                if(arr[i-1]>j){
                    dp[i][j]= dp[i-1][j];
                }else{
                    dp[i][j]= dp[i-1][j] || dp[i-1][j-arr[i-1]];
                }
            }
        }
        return dp[n][sum];
    }
}
