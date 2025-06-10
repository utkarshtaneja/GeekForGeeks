/*

Definition for Binary Tree Node
class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public static void dfs(Node node, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> ans) {
        if (node == null) return;
        path.add(node.data);

        if (node.left == null && node.right == null) {
            ans.add(new ArrayList<>(path)); 
        } 
        else{
            dfs(node.left, path, ans);  
            dfs(node.right, path, ans); 
        }

        path.remove(path.size() - 1);
    }
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        // code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        dfs(root, new ArrayList<>(), ans);
        return ans;
    }
}