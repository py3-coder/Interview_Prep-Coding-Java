
import java.util.*;
import java.lang.*;
public class Main
{
    public static void min_max(int arr[]){
        int min =arr[0];
        int max =arr[0];
        
        for(int i=0;i<arr.length;i++){
            if(arr[i]> max){
                max = arr[i];
            }
            if(arr[i]< min){
                min = arr[i];
            }
        }
        System.out.println("Max :"+max +" "+"Min :"+ min);
        
    } 
	public static void main(String[] args) {
	    int arr[] ={1,2,3,4,5};
	    min_max(arr);
	}
}
