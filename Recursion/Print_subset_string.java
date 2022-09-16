/*
Print all subset of String:
I/P - "abcd"
O/P -[ ,  d,  c,  cd,  b,  bd,  bc,  bcd,  a,  ad,  ac,  acd,  ab,  abd,  abc,  abcd]
*/


import java.util.*;
public class Main
{
    public static ArrayList<String> res=new ArrayList<>();
    public static void printSubset(String ip , String op){
        if(ip.length()==0){
            //System.out.println(op);
            res.add(op);
            return;
        }
        String op1 =op;
        String op2 =op;
        
        op2+=ip.charAt(0);
        ip =ip.substring(1);
        
        printSubset(ip,op1);
        printSubset(ip,op2);
    }
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    String ip = sc.nextLine();
	    String op=" ";
	    printSubset(ip,op);
	    System.out.println(res);
	}
}
