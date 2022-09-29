// Custom Comparator Lemda Expression...
// Test 1 : One-d arrays  && List
import java.util.*;
public class Main
{
    Scanner sc = new Scanner(System.in);
    public static void Sort1(){
        // Case 1:
        System.out.println("Array");
        Integer[] arr ={1,2,4,-4,6,3,9,-1};
        // Increasing Order by default by Arrays.sort:
        Arrays.sort(arr);
        System.out.println("Increasing Order by Arrays.sort");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        Arrays.sort(arr,(a,b)->{          ///  Arrays.sort(arr,(a,b)->a-b);
            return a-b;
        });
        System.out.println("Increasing Order by Custom Comparator using Lembda Expression");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        /*
        Arrays.sort(arr,(a,b)->{          /// Arrays.sort(arr,(a,b)->b-a);
            return b-a;
        });
        */
        Arrays.sort(arr,(a,b)->b-a);
        System.out.println("Decreasing Order by Custom Comparator using Lembda Expression");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void Sort2(){
        // Case 2:
        
        System.out.println("List");
        Integer[] arr ={1,2,4,-4,6,3,9,-1};
        List<Integer> lst = new ArrayList<>(Arrays.asList(arr));
        
        Collections.sort(lst);
        System.out.println("Increasing Order by Collections.sort");
        System.out.println(lst);
        
        Collections.sort(lst,(a,b)->(a-b));
        System.out.println("Increasing Order by Custom Comparator");
        System.out.println(lst);
        
        Collections.sort(lst,(a,b)->(b-a));
        System.out.println("Decreasingcreasing Order by Custom Comparator");
        System.out.println(lst);
    }
	public static void main(String[] args) {
		Sort1(); 
		Sort2();
		
	}
}

/*
Array
Increasing Order by Arrays.sort
-4 -1 1 2 3 4 6 9 
Increasing Order by Custom Comparator using Lembda Expression
-4 -1 1 2 3 4 6 9 
Decreasing Order by Custom Comparator using Lembda Expression
9 6 4 3 2 1 -1 -4 
List
Increasing Order by Collections.sort
[-4, -1, 1, 2, 3, 4, 6, 9]
Increasing Order by Custom Comparator
[-4, -1, 1, 2, 3, 4, 6, 9]
Decreasing Order by Custom Comparator
[9, 6, 4, 3, 2, 1, -1, -4]

*/
