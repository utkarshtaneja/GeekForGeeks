//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            int[][] edges = new int[E][2];
            for (int i = 0; i < E; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
            }

            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, edges);
            System.out.println(ans ? "true" : "false");
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    public static boolean dfs(int curr, boolean[] vis, int parent, ArrayList<ArrayList<Integer>> adj){
        vis[curr] = true;
        
        for(int val : adj.get(curr)){
            if(!vis[val]){
                if(dfs(val, vis, curr, adj)) return true;
            }
            else if(val != parent){
                return true;
            }
        }
        return false;
    }
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i = 0;i < V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        boolean[] vis = new boolean[V];
        Arrays.fill(vis, false);
        
        for(int i = 0;i < V;i++){
            if(!vis[i]){
                if(dfs(i, vis, -1, adj)) return true;
            }  
        }
        
        return false;
    }
}