/*
Write an efficient program to print all the duplicates and their counts in the input string 

intput : Saurabhgupta
Output : a, count = 3
         u, count = 2
*/



import java.util.*;
public class Main
{
    public static void stringCount(String str){
    Map<Character , Integer> map = new HashMap<>();
        for(int i=0;i<str.length();i++){
            map.put(str.charAt(i),map.getOrDefault(str.charAt(i),0)+1);
        }
        for (Map.Entry<Character,Integer> mapp : map.entrySet()) {   
            if (mapp.getValue() > 1)   
            System.out.println(mapp.getKey() + ", count = " + mapp.getValue());
        }
    }
	public static void main(String[] args) {
      stringCount("Saurabhgupta");
	}
}
