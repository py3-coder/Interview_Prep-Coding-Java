import java.util.*;
class Pair{
    int val1=0;
    int val2=0;
    Pair(int val1,int val2){
        this.val1 = val1;
        this.val2 =val2;
    }
}
public class Main
{   
    public static Scanner sc = new Scanner(System.in);
    // Case 1 : Sort List(Pair) based on first value of pair....
    public static void Sort1(){
        List<Pair> lst = new ArrayList<>();
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            int a = sc.nextInt();
            int b =sc.nextInt();
            lst.add(new Pair(a,b));
        }
        System.out.println("OutPut :");
        Collections.sort(lst,(a,b)->{
            return a.val1-b.val1;
        });
        for(Pair pair :lst){
            System.out.print(pair.val1+" ");
            System.out.print(pair.val2);
            System.out.println();
        }
    }
    // Case 2: Sort List(Pair) based on first value of pair if first value is same with second then arrange in incresing on second value
    public static void Sort2(){
        List<Pair> lst = new ArrayList<>();
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            int a = sc.nextInt();
            int b =sc.nextInt();
            lst.add(new Pair(a,b));
        }
        System.out.println("OutPut :");
        Collections.sort(lst,(a,b)->{
            if(a.val1 == b.val1){
                return a.val2-b.val2;
            }
            return a.val1-b.val1;
        });
        for(Pair pair :lst){
            System.out.print(pair.val1+" ");
            System.out.print(pair.val2);
            System.out.println();
        }
    }
	public static void main(String[] args) {
	    //Sort1();
	    Sort2();
		System.out.println("Hello World");
	}
}
// Input :
3
1 5
1 -4
1 10
// OutPut :
OutPut :
1 -4
1 5
1 10
Hello World
