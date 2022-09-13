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
