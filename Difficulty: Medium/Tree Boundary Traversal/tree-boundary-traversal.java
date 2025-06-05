/*
class Node
{
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    public static boolean isLeafNode(Node node){
        return node.left == null && node.right == null;
    }
    public static void addLeftBoundary(Node node, ArrayList<Integer> ans) {
        Node curr = node.left;
        while(curr != null){
            if(!isLeafNode(curr)) ans.add(curr.data);
            if(curr.left != null) curr = curr.left;
            else{
                curr = curr.right;
            }
        }
    }
    public static void addLeafNodes(Node node, ArrayList<Integer> ans) {
        if(isLeafNode(node)){
            ans.add(node.data);
            return;
        }
        if(node.left != null) addLeafNodes(node.left, ans);
        if(node.right != null) addLeafNodes(node.right, ans);
    }
    public static void addRightBoundary(Node node, ArrayList<Integer> ans) {
        Node curr = node.right;
        ArrayList<Integer> temp = new ArrayList<>();
        while(curr != null){
            if(!isLeafNode(curr)) temp.add(curr.data);
            if(curr.right != null) curr = curr.right;
            else{
                curr = curr.left;
            }
        }
        for(int i = temp.size() - 1;i >= 0;i--){
            ans.add(temp.get(i));
        }
    }
    ArrayList<Integer> boundaryTraversal(Node node) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        if(!isLeafNode(node)) ans.add(node.data);
        addLeftBoundary(node, ans);
        addLeafNodes(node, ans);
        addRightBoundary(node, ans);
        
        return ans;
    }
}