//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends

// Using BFS

// class Solution {
//     static class Pair{
//         int src;
//         int parent;
        
//         public Pair(int src, int parent){
//             this.src = src;
//             this.parent = parent;
//         }
//     }
//     public static boolean check(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj, int V){
//         vis[node] = true;
        
//         Queue<Pair> q = new LinkedList<>();
//         q.add(new Pair(node, -1));
        
//         while(!q.isEmpty()){
//             Pair curr = q.poll();
//             int src = curr.src;
//             int parent = curr.parent;
            
//             for(int val : adj.get(src)){
//                 if(vis[val] == true){
//                     if(parent != val){
//                         return true;
//                     }
//                 }
//                 else{
//                     vis[val] = true;
//                     q.add(new Pair(val, src));
//                 }
//             }
//         }
        
//         return false;
//     }
//     // Function to detect cycle in an undirected graph.
//     public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
//         // Code here
//         boolean[] vis = new boolean[V];
        
//         Arrays.fill(vis, false);
        
//         for(int i = 0;i < V;i++){
//             if(vis[i] == false){
//                 if(check(i, vis, adj, V)){
//                     return true;
//                 }
//             }
//         }
        
//         return false;
//     }
// }


// Using DFS

class Solution {
    public static boolean dfs(int src, int parent, boolean[] vis, ArrayList<ArrayList<Integer>> adj, int V){
        vis[src] = true;
        
        for(int val : adj.get(src)){
            if(vis[val] == false){
                if(dfs(val, src, vis, adj, V)) return true;
            }
            else if(val != parent){
                return true;
            }
        }
        
        return false;
    }
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] vis = new boolean[V];
        
        Arrays.fill(vis, false);
        
        for(int i = 0;i < V;i++){
            if(vis[i] == false){
                if(dfs(i, -1, vis, adj, V)) return true;
            }
        }
        
        return false;
    }
}