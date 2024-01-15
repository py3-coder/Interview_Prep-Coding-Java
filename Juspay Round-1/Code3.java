 import java.util.Scanner; 
import java.util.ArrayList; 
 
/* IMPORTANT: Multiple classes and nested static classes are supported */ 
 
/* 
 * uncomment this if you want to read input. 
//imports for BufferedReader 
import java.io.BufferedReader; 
import java.io.InputStreamReader; 
 
//import for Scanner and other utility classes 
import java.util.*; 
*/ 
 
// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail 
 
class TestClass { 
    public static void main(String args[] ) throws Exception { 
        /* Sample code to perform I/O: 
         * Use either of these methods for input 
 
        //BufferedReader 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        String name = br.readLine();                // Reading input from STDIN 
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT 
 
        //Scanner 
        Scanner s = new Scanner(System.in); 
        String name = s.nextLine();                 // Reading input from STDIN 
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT 
 
        */ 
 
        // Write your code here 
        int[] vis =new int[1000001]; 
        Scanner sc =new Scanner(System.in); 
        int n =sc.nextInt(); 
        int[] node =new int[n]; 
        int maxi=0; 
        for(int i=0;i<n;i++){ 
            node[i] =sc.nextInt(); 
            maxi =Math.max(maxi,node[i]); 
        } 
        int edgeCnt =sc.nextInt(); 
        ArrayList<ArrayList<Integer>> adj =new ArrayList<>(); 
        for(int i=0;i<maxi+1;i++){ 
            adj.add(new ArrayList<>()); 
        } 
        for(int i=0;i<edgeCnt;i++){ 
            int u =sc.nextInt(); 
            int v =sc.nextInt(); 
 
            adj.get(u).add(v); 
            adj.get(v).add(u); 
        } 
        int src =sc.nextInt(); 
        int dest =sc.nextInt(); 
         
        if(dfs(src, dest, vis, adj)==true){ 
            System.out.print(1); 
            return; 
        } 
        System.out.print(0); 
 
         
 
    } 
    public static boolean dfs(int src,int dest,int[] vis,ArrayList<ArrayList<Integer>> adj){ 
        vis[src]=1; 
        if(src==dest){ 
            return true; 
        } 
        for(int currNode : adj.get(src)){ 
            if(vis[currNode]!=1){ 
                if(dfs(currNode, dest, vis, adj)==true){ 
                    return true; 
                } 
            } 
        } 
        return false; 
    } 
}
