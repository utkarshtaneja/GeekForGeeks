/* A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/
class Solution {
    // Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        
        Queue<Node> q = new LinkedList<>();
        
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0;i < size;i++){
                Node curr = q.poll();
                if(i == 0) ans.add(curr.data);
                
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
        }
        
        return ans;
    }
}