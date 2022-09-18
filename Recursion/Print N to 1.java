//-----  Program to print N to 1 ---
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
        System.out.print(n+" ");   //Induction
        print1_n(--n);
    }
	public static void main(String[] args) {
		System.out.println("Print 1 to N using Recursion");
		print1_n(10);
	} 
}
