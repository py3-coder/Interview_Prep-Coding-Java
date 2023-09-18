//Problem :: Sort Stack using Recursion :::
import java.util.*;
public class Main
{
	public static void main(String[] args) {
	    Stack<Integer> st = new Stack<>();
	    st.push(9);
	    st.push(-4);
	    st.push(2);
	    st.push(7);
	    st.push(11);
	    st.push(1);
	    sortStackRecursion(st);
	    //TC : O(n^2)
	    //SC : O(1) 
	    //Auxillary Space : O(2n) -- Recursion Stack
	    System.out.println(st);
		
	}
	public static void sortStackRecursion(Stack<Integer> st){
	    //B H I 
	    //Base case ::
	    if(st.size()==1){
	        return;
	    }
	    //Hypothesis:: 
	    int ele =st.pop();
	    //Induction:::
	    sortStackRecursion(st);
	    insertEle(st,ele);
	    
	}
	public static void insertEle(Stack<Integer> st,int temp){
	    //Base Case  :::
	    if(st.size()==0 || st.lastElement()<=temp){
	        st.push(temp);
	        return ;
	    }
	    //Hypothesis:::
	    int lastele =st.pop();
	    insertEle(st,temp);
	    st.push(lastele);
	}
}

