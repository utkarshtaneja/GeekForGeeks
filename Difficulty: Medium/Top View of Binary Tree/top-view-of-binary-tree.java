/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Solution {
    static class Pair{
        int line;
        Node node;
        
        public Pair(int line, Node node){
            this.line = line;
            this.node = node;
        }
    }
    // Function to return a list of nodes visible from the top view
    // from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        
        Queue<Pair> q = new LinkedList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        q.add(new Pair(0, root));
        
        while(!q.isEmpty()){
            Pair curr = q.poll();
            int line = curr.line;
            Node temp = curr.node;
            
            if(!map.containsKey(line)){
                map.put(line, temp.data);
            }
            
            if(temp.left != null){
                q.add(new Pair(line - 1, temp.left));
            }
            
            if(temp.right != null){
                q.add(new Pair(line + 1, temp.right));
            }
        }
        
        for(Map.Entry<Integer, Integer> e : map.entrySet()){
            ans.add(e.getValue());
        }
        return ans;
    }
}