//Problem Statement :: https://practice.geeksforgeeks.org/problems/help-classmates--141631/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

class Solution {
	public static int[] help_classmate(int arr[], int n) 
	{ 
	    // Your code goes here
	    //Lets Play with Stack::: why stack ::
	    // broute force :: 
	    // for(int i=0;i<n;i++){
	   //  for(int j=i-1;j>=0;j--){}  --since j is dependent on i -------think of stack:::   
	    //}
	    
	    int[] res = new int[arr.length];
	    Stack<Integer> st = new Stack<>();
	    for(int i=n-1;i>=0;i--){
	        if(st.isEmpty()){
	            res[i] =-1;
	        }else if(st.peek()<arr[i]){
	            res[i] =st.peek();
	        }else{
	            while(!st.isEmpty() && st.peek()>=arr[i]){
	                st.pop();
	            }
	            if(st.isEmpty()){
	                res[i] =-1;
	            }else{
	                res[i] =st.peek();
	            }
	        }
	        st.push(arr[i]);
	    }
	    return res;
	} 
}
