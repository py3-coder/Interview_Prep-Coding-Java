import java.util.* ;
import java.io.*; 
/************************************************************

    Following is the TreeNode class structure:

    class BinaryTreeNode {
		int val;
		BinaryTreeNode left;
		BinaryTreeNode right;

		BinaryTreeNode(int val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}

************************************************************/
class Pair{
    int data;
    BinaryTreeNode node;
    Pair(int data,BinaryTreeNode root){
        this.data=data;
        this.node=root;
    }
}
public class Solution {
	public static ArrayList<Integer> getTopView(BinaryTreeNode root) {
		// Write your code here.
        TreeMap<Integer,Integer> map = new TreeMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        if(root==null) return res;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(0,root));
        while(!queue.isEmpty()){
            Pair pp = queue.remove();
            int col =pp.data;
            BinaryTreeNode curr =pp.node;
            map.putIfAbsent(col, curr.val);
            if(curr.left!=null){
                queue.offer(new Pair(col-1,curr.left));
            }
            if(curr.right!=null){
                queue.offer(new Pair(col+1,curr.right));
            }
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            res.add(entry.getValue());
        }
        return res;
	}
}
