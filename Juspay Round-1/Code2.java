import java.util.ArrayList; 
import java.util.Collections; 
import java.util.Scanner; 
 
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
 
        Scanner sc =new Scanner(System.in); 
        int n  = sc.nextInt(); 
        int[] nodes =new int[n]; 
        int maxi=0; 
        for(int i=0;i<n;i++){ 
            nodes[i] =sc.nextInt(); 
            maxi =Math.max(maxi,nodes[i]); 
        } 
        int edgeCnt =sc.nextInt(); 
        ArrayList<ArrayList<Integer>> adj =new ArrayList<>(); 
        for(int i=0;i<maxi+1;i++){ 
            adj.add(new ArrayList<>()); 
        } 
        int[] vis =new int[1000001]; 
        for(int i=0;i<edgeCnt;i++){ 
            int u =sc.nextInt(); 
            int v =sc.nextInt(); 
            adj.get(u).add(v); 
        } 
        int src =sc.nextInt(); 
        int dest =sc.nextInt(); 
        ArrayList<ArrayList<Integer>> paths =new ArrayList<>(); 
        dfs(src,dest,vis,paths,new ArrayList<>(),adj); 
        ArrayList<Integer> res =new ArrayList<>(); 
        res.add(src); 
        for(ArrayList<Integer> temp : paths){ 
            for(int ele:temp){ 
                if(ele!=dest){ 
                    res.add(ele); 
                } 
            } 
        } 
        Collections.sort(res); 
        for(int ele: res){ 
            System.out.print(ele+" "); 
        } 
 
    } 
    public static void dfs(int src,int dest,int[] vis,ArrayList<ArrayList<Integer>> paths, 
    ArrayList<Integer> temp,ArrayList<ArrayList<Integer>> adj){ 
        if(src == dest){ 
            paths.add(new ArrayList<>(temp)); 
            return; 
        } 
        vis[src]=1; 
        for(int ele :adj.get(src)){ 
            if(vis[ele]!=1){ 
                temp.add(ele); 
                dfs(ele, dest, vis, paths, temp, adj); 
                temp.remove(temp.size()-1); 
            } 
        } 
        vis[src]=0; 
    } 
}
