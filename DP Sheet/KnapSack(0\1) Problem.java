import java.util.*;
public class Main
{   //Recursion+Memoization
    public static int solveR(int n,int maxAmt,int prices[],int container[],int dp[]){
        if( n==0 || maxAmt==0) return 0;
        if(dp[n]!=-1){
            return dp[n];
        }
        if(prices[n-1]>maxAmt){
            return solveR(n-1,maxAmt,prices,container,dp);
        }
        int take = container[n-1]+solveR(n-1,maxAmt-prices[n-1],prices,container,dp);
        int not_take = solveR(n-1,maxAmt,prices,container,dp);
        dp[n-1] =Math.max(take,not_take);
        return dp[n-1];
    }
	public static void main(String[] args) {
	    int n=5;
	    int maxAmt =105;
	    int prices[] ={10,10,40,50,90};
	    int container[] ={10,20,20,50,150};
	    //int dp[] =new int[maxAmt+1];
	    //Arrays.fill(dp,-1);
	    //int a =solveR(n,maxAmt,prices,container,dp);
		//System.out.println(a);
		
		//Tabulation...
		int dp[][] = new int[n+1][maxAmt+1];
		for(int i=0;i<n+1;i++){
		    for(int j=0;j<maxAmt+1;j++){
		        if(i==0 || j==0){
		            dp[i][j]=0;
		        }else if(j>=prices[i-1]){
		            int val = j-prices[i-1];
		            dp[i][j] = Math.max(container[i-1]+dp[i-1][val],dp[i-1][j]);
		        }else{
		            dp[i][j] =dp[i-1][j];
		        }
		    }
		}
		 System.out.println(dp[n][maxAmt]);
	}
}

