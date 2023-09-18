/*
Problem Statement : Reverse an stack using Recursion 


TC : O(n^2)   SC : O(1)  but for Recursive call it uses Auxillary Recursion Stack --> O(2n)
*/
import java.util.*;
public class Main
{
    public static void ReverseStack(Stack<Integer> st){
        /// B   H   I 
        // Base Case 
        if(st.size()==1){
            return;
        }
        // Hypothesis
        int temp = st.pop();
        ReverseStack(st);
        //Induction 
        insert(st,temp);
        return;
        
    }
    public static void insert(Stack<Integer> st , int ele){
        /// B  H  I
        
        //Base
        if(st.size()==0){
            st.push(ele);
            return;
        }
        /// Hypothesis 
        int val = st.pop();
        insert(st,ele);
        //Induction
        st.push(val);
        return;
    }
	public static void main(String[] args) {
	    Stack<Integer> st = new Stack<>();
	    st.push(2);
	    st.push(5);
	    st.push(-3);
	    st.push(10);
	    
	    ReverseStack(st);
		System.out.println(st);
	}
}

//Updated One ::
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

