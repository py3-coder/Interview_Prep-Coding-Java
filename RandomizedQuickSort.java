
import java.util.*;
public class Main{
    // low == index 0 , high ==( size -1 )index
    public static void QuickSortRandomPivot(int arr[] , int  low ,int  high){
        
        if(low<high){
            int pi = partition(arr, low, high);
            //Sorting 
            QuickSortRandomPivot(arr,low,pi-1);
            QuickSortRandomPivot(arr,pi+1,high);
        }
    }
    // implementing random pivot selection swaping the random pivot selected with high
    public static void RandomSelector(int arr[], int low , int high){
        Random rand = new Random();
        int random = rand.nextInt(high-low)+low;
        
        int temp = arr[random];
        arr[random] = arr[high];
        arr[high] = temp;
        
    }
    // partition function
    public static int partition(int arr[] , int low , int high){
        RandomSelector(arr , low , high);
        int pivot =arr[high];
        int i = low-1;
        for(int j = low ; j<high;j++){
            if(arr[j]<pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                
            }
        }
        int temp =arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
       
        return i+1;
    }
    // main function 
    public static void main(String args[]){
        int arr[] = {10, 17, 8, 9, 2, 5};
        QuickSortRandomPivot(arr,0,arr.length-1);
        
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    
}
