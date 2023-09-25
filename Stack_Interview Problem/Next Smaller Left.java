https://practice.geeksforgeeks.org/problems/help-classmates--141631/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

class Solution{
    static List<Integer> leftSmaller(int n, int arr[])
    {
        //Lets Play with Stack::
        List<Integer> res = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            if(st.isEmpty()){
                res.add(-1);
            }else if(st.peek()<arr[i]){
                res.add(st.peek());
            }else{
                while(!st.isEmpty() && st.peek()>=arr[i]){
                    st.pop();
                }
                if(st.isEmpty()){
                    res.add(-1);
                }else{
                    res.add(st.peek());
                }
            }
            st.push(arr[i]);
        }
        return res;
    }
}
