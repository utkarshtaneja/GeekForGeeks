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


class Solution {
    static class Pair{
        int node;
        int src;
        
        public Pair(int node, int src){
            this.node = node;
            this.src = src;
        }
    }
    public static boolean check(int curr, boolean[] vis, ArrayList<ArrayList<Integer>> adj){
        vis[curr] = true;
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(curr, -1));
        
        while(!q.isEmpty()){
            Pair p = q.poll();
            int node = p.node;
            int src = p.src;
            
            for(int connected : adj.get(node)){
                if(vis[connected]){
                    if(src != connected){
                        return true;
                    }
                }
                else{
                    q.add(new Pair(connected, node));
                    vis[connected] = true;
                }
            }
        }
        
        return false;
    }
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        
        // Using BFS
        boolean[] vis = new boolean[V];
        Arrays.fill(vis, false);
        
        for(int i = 0;i < V;i++){
            if(!vis[i]){
                if(check(i, vis, adj)){
                    return true;
                }
            }
        }
        return false;
    }
}