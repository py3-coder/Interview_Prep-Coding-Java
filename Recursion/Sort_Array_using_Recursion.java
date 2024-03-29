/*
Problem Statement : Sort and Array Using Recursion ..

TC : O(n^2)    SC : O(1)  --> but recursive call use Auxillary Space..
*/

//Version :1
import java.util.*;
public class Main
{
    public static ArrayList sort(ArrayList<Integer> arr){
        //Base case
        if(arr.size()==1){
            return arr;
        }
        //Hypothesis
        int temp =arr.remove(arr.size()-1);
        //Induction
        arr  =sort(arr);
        arr  =insert(arr,temp);
        return arr;
    }
    public static ArrayList insert(ArrayList<Integer> arr,int temp){
        //Base Case
        if((arr.size()==0) || (arr.get(arr.size()-1)<=temp)){
            arr.add(temp);
            return arr;
        }
        //Hypothesis
        int val = arr.remove(arr.size()-1);
        //Induction
        arr = insert(arr,temp); 
        arr.add(val);
        
        return arr;
    }
	public static void main(String[] args) {
	    ArrayList<Integer> list = new ArrayList<>(Arrays.asList(3,5,6,-8,9,12,0));
	     list = sort(list);
	    System.out.println(list);
	}
}

//Version :02
import java.util.*;
public class Main
{
	public static void main(String[] args) {
	    ArrayList<Integer> list = new ArrayList<>(Arrays.asList(3,5,6,-8,9,12,0));
	    sortArrayRecurssion(list);
	    System.out.println(list);
		
	}
	public static void sortArrayRecurssion(ArrayList<Integer> arr){
	    //Base Case :::
	    if(arr.size()==1){
	        return ;
	    }
	    //Hypothesis:::
	    int val = arr.get(arr.size()-1);
	    arr.remove(arr.size()-1);
	    //Induction
	    sortArrayRecurssion(arr);
	    insertEle(arr,val);
	}
	public static void insertEle(ArrayList<Integer> arr,int temp){
	    //Base Case ::
	    if(arr.size()==0 || arr.get(arr.size()-1)<=temp){
	        arr.add(temp);
	        return;
	    }
	    //Hyposthesis..
	    int last =arr.get(arr.size()-1);
	    arr.remove(arr.size()-1);
	    //Induction..
	    insertEle(arr,temp);
	    arr.add(last);
	}
}



