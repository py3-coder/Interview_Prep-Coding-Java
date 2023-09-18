import java.util.*;
//Problem :: Delete a middle ele of Stack :::
//Using Recursion :::

public class Main
{
	public static void main(String[] args) {
	    Stack<Integer> st = new Stack<>();
	    st.push(9);
	    st.push(-4);
	    st.push(2);
	    st.push(7);
	    st.push(11);
	    
	    int mid =(st.size()/2)+1;
	    deleteMidStack(st,mid);
	    //TC : O(n)
	    //SC : O(1) 
	    //Auxillary Space : O(n) -- Recursion Stack
	    System.out.println(st);
		
	}
	public static void deleteMidStack(Stack<Integer> st,int indx){
	    //B H I 
	    //Base case ::
	    if(indx==1){
	        st.pop();
	        return;
	    }
	    //Hypothesis:: 
	    int ele =st.pop();
	    //Induction:::
	    deleteMidStack(st,indx-1);
	    st.push(ele);
	}
	
}
