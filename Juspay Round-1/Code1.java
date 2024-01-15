import java.util.ArrayList; 
import java.util.PriorityQueue; 
import java.util.Scanner; 
import java.util.Arrays; 
 
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
        Scanner sc = new Scanner(System.in); 
        int n =sc.nextInt(); 
        int[] node =new int[n]; 
        int maxi=0; 
        for(int i=0;i<n;i++){ 
            node[i] =sc.nextInt(); 
            maxi =Math.max(node[i],maxi); 
        } 
        int edge=sc.nextInt(); 
        ArrayList<ArrayList<Pair>> adj  =new ArrayList<>(); 
        for(int i=0;i<maxi+1;i++){ 
            adj.add(new ArrayList<>()); 
        } 
        for(int i=0;i<edge;i++){ 
            int u =sc.nextInt(); 
            int v =sc.nextInt(); 
            int dist =sc.nextInt(); 
            adj.get(u).add(new Pair(dist,v)); 
            adj.get(v).add(new Pair(dist,u)); 
        } 
        int src =sc.nextInt(); 
        int dest =sc.nextInt(); 
 
        int shortesttime =sourceDestination(src, dest, adj); 
        System.out.print(shortesttime); 
    } 
    public static int sourceDestination(int src ,int dest,ArrayList<ArrayList<Pair>> adj){ 
         
        int[] dst = new int[1000001]; 
        Arrays.fill(dst,(int)1e6); 
        PriorityQueue<Pair> pq =new PriorityQueue<>((a,b)->((a.dist==b.dist)?(a.node-b.node):(a.dist-b.dist))); 
 
        pq.offer(new Pair(0,src)); 
        dst[src]=0; 
        while(!pq.isEmpty()){ 
            Pair curr =pq.poll(); 
            int currnode =curr.node; 
            int dis =curr.dist; 
 
            if(currnode == dest){ 
                return dis; 
            } 
 
            for(Pair temp :adj.get(currnode)){ 
                int tempnode = temp.node; 
                int d =temp.dist; 
                if(dis+d<dst[tempnode]){ 
                    dst[tempnode]=dis+d; 
                    pq.offer(new Pair(dst[tempnode],tempnode)); 
                } 
            } 
        } 
        return -1; 
 
    } 
    static class Pair{ 
        int dist; 
        int node; 
        Pair(int _dist,int _node){ 
            this.dist=_dist; 
            this.node=_node; 
        } 
    } 
}
