/*
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

public class Main
{
	public static void main(String[] args) {
	    int arr[] ={3, 4, 5, 2};
	    int sum =6;
	    int n = arr.length;
	    Boolean dp[][] = new Boolean[n+1][sum+1];
	    boolean ans =subsetsum(arr,sum,n-1,dp);
	    System.out.print(ans);
	}
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
