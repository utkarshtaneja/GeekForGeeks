class Solution {
    static class Pair{
        int line;
        Node node;
        
        public Pair(int line, Node node){
            this.line = line;
            this.node = node;
        }
    }
    // Function to return a list containing the bottom view of the given tree.
    public ArrayList<Integer> bottomView(Node root) {
        // Code here
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        
        Queue<Pair> q = new LinkedList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        q.add(new Pair(0, root));
        
        while(!q.isEmpty()){
            Pair curr = q.poll();
            int line = curr.line;
            Node temp = curr.node;
            
            map.put(line, temp.data);
            
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