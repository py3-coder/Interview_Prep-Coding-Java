import java.util.*;
public class Main
/* Permutation With Case Change 
 Sample Test Case  :
 I/P = ab 
 O/P = ab aB Ab AB
*/
{
    public static void Solve(String Ip,String Op){
        if(Ip.length()==0){
            System.out.print(Op+" ");
            return;
        }
        String Op1 = Op;
        String Op2 =Op;
        
        Op1 +=Ip.charAt(0);
        Op2 +=Character.toUpperCase(Ip.charAt(0));
        Ip =Ip.substring(1);
        
        Solve(Ip,Op1);
        Solve(Ip,Op2);
        
    }
	public static void main(String[] args) {
	    Scanner scn = new Scanner(System.in);
	    String str = scn.nextLine();
	    String Op ="";
	    Solve(str,Op);
	}
}


/*
I/P =abc
O/P =abc abC aBc aBC Abc AbC ABc ABC
*/
