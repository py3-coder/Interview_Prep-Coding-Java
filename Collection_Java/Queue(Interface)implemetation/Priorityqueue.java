import java.util.*;
public class Priorityqueue
{
    static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		PriorityQueue<Integer> p_queue = new PriorityQueue<Integer>();
		for(int i=0;i<6;i++){
		    p_queue.add(sc.nextInt());
		}
		System.out.println(p_queue);
		//printing top element
		p_queue.peek();
		Iterator  itr = p_queue.iterator();
		while(itr.hasNext()){
		    System.out.println(itr.next());
		}
		//poll return the top element and remove the top element
		p_queue.poll();
		System.out.println(p_queue);
		p_queue.remove();
		System.out.println(p_queue);
		
	}
}
