/*******
Count of Non repeating digit 
Input  : 292
Output :1
Explanation: here 2 comes twice only 9 comes once so only one digit which is not repeating so output =1
Code :
*******/
import java.util.*;
public class Main
{
    public static int nonrepat(int input1){
        HashMap<Integer , Integer> map = new HashMap<>();
		int temp = input1;
		int digit=0;
		while(temp>0){
			digit =temp%10;
			if(map.containsKey(digit)){
				map.put(digit, map.get(digit)+1);
			}
			else map.put(digit, 1);
			temp =temp/10;
		}
        int count=0;
        for(int a :map.values()){
            if(a==1){
                count++;
            }
        }
		return  count;
	}
    
	public static void main(String[] args) {
		int res =nonrepat(292);
		System.out.println(res);
	}
}
