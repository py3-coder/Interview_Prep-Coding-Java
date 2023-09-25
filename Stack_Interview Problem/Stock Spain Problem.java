import java.util.*;
public class Main
{
	public static void main(String[] args) {
	    int[] arr =new int[]{10,4,5,90,120,80};
		int res[] = stockSpain(arr,arr.length);
		for(int i=0;i<res.length;i++){
		    System.out.print(res[i]+" ");
		}
	}
	public static int[]  stockSpain(int[] arr ,int n){
	    Stack<Integer> st = new Stack<>();
	    int[] res = new int[n];
	    
	    for(int i=0;i<n;i++){
	        if(st.isEmpty()){
	            res[i] =1;
	        }else if(arr[st.peek()]>arr[i]){
	            res[i] =1;
	        }else{
	            while(!st.isEmpty() && arr[st.peek()]<=arr[i]){
	                st.pop();
	            }
	            if(st.isEmpty()){
	                res[i] =i+1;
	            }else{
	                res[i] =i-st.peek();
	            }
	        }
	        st.push(i);
	    }
	    return res;
	}
}


//Probelem Link :https://www.codingninjas.com/studio/problems/stock-span_5243295?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTab=1
//Soln ::
import java.util.*;
public class Solution {
    public static int[] findStockSpans(int []arr) {
        // Write your code here.
        int n=arr.length;
        Stack<Integer> st = new Stack<>();
	    int[] res = new int[n];
	    
	    for(int i=0;i<n;i++){
	        if(st.isEmpty()){
	            res[i] =1;
	        }else if(arr[st.peek()]>=arr[i]){
	            res[i] =1;
	        }else{
	            while(!st.isEmpty() && arr[st.peek()]<arr[i]){
	                st.pop();
	            }
	            if(st.isEmpty()){
	                res[i] =i+1;
	            }else{
	                res[i] =i-st.peek();
	            }
	        }
	        st.push(i);
	    }
	    return res;
    }
}
