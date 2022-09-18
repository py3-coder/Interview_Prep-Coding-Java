//-----  Program to print 1 to N ---
import java.util.*;
public class Main
{
    public static void print1_n(int n){
        ///Base Case
        if(n==0){
            return;
        }
        //Hypothesis
        //n=n-1; == --n  != n--  
        // diff bet --n will first reduce and then work and in n-- it will first work then reduce---
        print1_n(--n);
        //Induction
        System.out.print((n+1)+" ");
    }
	public static void main(String[] args) {
		System.out.println("Print 1 to N using Recursion");
		print1_n(10);
	} 
}
