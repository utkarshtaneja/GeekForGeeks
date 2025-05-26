class Solution {
    public static void dfs(int curr, boolean[] vis, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st){
        vis[curr] = true;
        
        for(int val : adj.get(curr)){
            if(!vis[val]){
                dfs(val, vis, adj, st);
            }
        }
        
        st.push(curr);
    }
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        
        // Using DFS and Stack
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);
        
        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }
        
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            
            adj.get(u).add(v);
        }
        
        boolean[] vis = new boolean[V];
        Arrays.fill(vis, false);
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0;i < V;i++){
            if(!vis[i]){
                dfs(i, vis, adj, st);
            }
        }
        
        ArrayList<Integer> topo = new ArrayList<>();
        while(!st.isEmpty()) {
            topo.add(st.peek());
            st.pop();
        }
        
        return topo;
    }
}