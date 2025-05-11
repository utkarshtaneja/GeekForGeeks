//{ Driver Code Starts
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
            boolean ans = obj.isCyclic(V, edges);
            System.out.println(ans ? "true" : "false");
        }
        sc.close();
    }
}
// } Driver Code Ends


class Solution {
    public static boolean dfs(int curr, boolean[] vis, boolean[] pathVis, ArrayList<ArrayList<Integer>> adj){
        vis[curr] = true;
        pathVis[curr] = true;
        
        for(int val : adj.get(curr)){
            if(!vis[val]){
                if(dfs(val, vis, pathVis, adj)){
                    return true;
                }
            }
            else if(vis[val] && pathVis[val]){
                return true;
            }
        }
        pathVis[curr] = false;
        return false;
    }
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i = 0;i < V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
        }
        
        boolean[] vis = new boolean[V];
        boolean[] pathVis = new boolean[V];
        Arrays.fill(vis, false);
        Arrays.fill(pathVis, false);
        
        for(int i = 0;i < V;i++){
            if(!vis[i]){
                if(dfs(i, vis, pathVis, adj)){
                    return true;
                }
            }
        }
        return false;
    }
}