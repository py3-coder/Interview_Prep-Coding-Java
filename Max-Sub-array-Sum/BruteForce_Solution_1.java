import java.util.*;
public class Main{
    //BruteForce Solution:1
    static int maxsum(int A[],int n){
        int max_sum=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int sum=0;
                for(int k=i;k<j+1;k++){
                    sum=sum+A[k];
                }
                if(sum>max_sum){
                    max_sum=sum;
                }
            }
        }
        return max_sum;
    }
    //Time complexity :O(n^3)
    //Space complexity: O(1)

    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the length of Array:");
        int len =sc.nextInt();
        int arr[] = new int[len];
        for(int i=0;i<len;i++){
            arr[i] =sc.nextInt();
        }
        System.out.println("max-Sub-array-Sum: "+maxsum(arr,len));
        
    }
}
