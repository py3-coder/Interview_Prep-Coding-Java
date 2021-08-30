import java.util.*;
import java.util.concurrent.PriorityBlockingQueue;
public class PriorityBlockingQueue
{  
    //the PriorityQueue and LinkedList are not thread-safe.
    //PriorityBlockingQueue is one alternative implementation if thread-safe implementation is needed.
    //PriorityBlockingQueue is an unbounded blocking queue that uses the same ordering rules as
    //class PriorityQueue and supplies blocking retrieval operations.
    static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		PriorityBlockingQueue<Integer> PBQ = new PriorityBlockingQueue<Integer>();
		for(int i=0;i<6;i++){
		    PBQ.add(sc.nextInt());
		}
		System.out.println(PBQ);
		//return top and also remove top element
		System.out.println(PBQ.poll());
		//return top
		System.out.println(PBQ.peek());
		//
		System.out.println(PBQ);
		// remove element 
		PBQ.remove(6);
		System.out.println(PBQ);
	}
}
