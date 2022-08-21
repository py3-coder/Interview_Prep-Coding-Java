/*
Given N and M, find the minimum number of primes required to make N, you can use the first M primes to do so.. [N <= 10^3] [M<=10^4] 
Input: 
N = 10 
M = 1 
Output: 
5 
Explanation: Minimum we require 5 primes [2 + 2 + 2 + 2 + 2] 
Input: 
N = 11 
M = 3 
Output: 
3
Explanation: Minimum we require 3 primes [5 + 3 + 2] 
*/
import java.util.*;
public class Main
{
    public static List<Integer> getNPrime(int n,int m){
        ArrayList<Integer> mPrime = new ArrayList<>();
        boolean prime[] = new boolean[n+1];
        for(int i=0;i<n;i++)
        prime[i] =true;
        
        for(int i=2;i*i<=n;i++){
            if(prime[i] ==true){
                for(int j=i*i;j<=n;j+=i){
                    prime[j] =false;
                }
            }
        }
        for(int i=2;i<n;i++){
            if(prime[i]==true && m>0){
                m--;
                mPrime.add(i);
            }
        }
        return mPrime;
    }
	public static int MinimimPrimeReqSum(int n,int m) {
	    int prime[] = new int[m+1]; 
	    int count=0;
	    for(int i:getNPrime(n,m)){
	        prime[count] =i;
	        //System.out.println(prime[count]);
	        count++;
	        
	    }
	    int dp[] = new int[n+1]; 
	    for(int i=0;i<n+1;i++){ 
	        dp[i] =10000000;
	    }
	    dp[0]=0;
	    dp[2]=1;
	    for(int i=2;i<=n;i++){ 
	        for(int j=0;j<=m;j++){
	            if(prime[j]<=i){   
	                int rem=i-prime[j];
	                dp[i] =Math.min(dp[i],1+dp[rem]);
	            }
	        }
	    }
	    if(dp[n]==10000000|| dp[n]==0){
	        return -1;
	    }
	    return dp[n];
	}
	public static void main(String args[]){
	    System.out.print(MinimimPrimeReqSum(12,3));
	}
	
}
