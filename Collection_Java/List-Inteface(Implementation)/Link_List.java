import java.util.*;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        //implementation of List using LinkedList
       //creating a linked list object 
        LinkedList<Integer> L1 =new LinkedList<Integer>();
        for(int i=0;i<6;i++){
            //add the element in order by taking input from user
            L1.add(sc.nextInt());
        }
        System.out.println("L1:"+L1+" ");
        //element of specific index
        L1.add(2,20);
        
        //creating new LinkedList L2
        LinkedList<Integer> L2 = new LinkedList<Integer>();
        for(int i=0 ;i<10;i++){
            L2.add(i);
        }
        System.out.println("L2:"+L2+" ");
          //creatinging new LinkedList L2
         LinkedList<Integer> L3 = new LinkedList<Integer>();
        for(int i=12 ;i<18;i++){
            L3.add(i);
        }
        //adding all element of L2 to L1
        L1.addAll(L2);
        System.out.println("Updated L1:"+L1+" ");
        //add all at specific 
        L1.addAll(2,L3);
        System.out.println("Updated L1:"+L1+" ");
        // remove element by index 
        L1.remove(1);
        System.out.println("Updated L1:"+L1+" ");
        //remove the first element
        L1.removeFirst();
        System.out.println("Updated L1:"+L1+" ");
        //remove last element
        L1.removeLast();
        System.out.println("Updated L1:"+L1+" ");
        //removeFirstOccurrence
        L1.removeFirstOccurrence(2);
        //removelastOccurance
        L1.removeFirstOccurrence(2);
        System.out.println("Final L1:"+L1+" ");
    }
}
