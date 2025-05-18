//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            int x = V;
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());

            int[][] edges = new int[E][2];
            for (int i = 0; i < E; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
                adj.get(edges[i][0]).add(edges[i][1]);
            }

            ArrayList<Integer> res = new Solution().topoSort(V, edges);

            if (check(adj, x, res) == true)
                System.out.println("true");
            else
                System.out.println("false");
            System.out.println("~");
        }
    }

    static boolean check(ArrayList<ArrayList<Integer>> adj, int V,
                         ArrayList<Integer> res) {

        if (V != res.size()) return false;

        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res.get(i)] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : adj.get(i)) {
                if (map[i] > map[v]) return false;
            }
        }
        return true;
    }
}

// } Driver Code Ends


class Solution {
    // public static void dfs(int curr, boolean[] vis, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st){
    //     vis[curr] = true;
        
    //     for(int val : adj.get(curr)){
    //         if(!vis[val]){
    //             dfs(val, vis, adj, st);
    //         }
    //     }
        
    //     st.push(curr);
    // }
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        // ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        // for(int i = 0;i < V;i++){
        //     adj.add(new ArrayList<>());
        // }
        
        // for(int[] edge: edges){
        //     int u = edge[0];
        //     int v = edge[1];
        //     adj.get(u).add(v);
        // }
        
        // boolean[] vis = new boolean[V];
        // Arrays.fill(vis, false);
        // Stack<Integer> st = new Stack<>();
        
        // for(int i = 0;i < V;i++){
        //     if(!vis[i]){
        //         dfs(i, vis, adj, st);
        //     }
        // }
        
        // ArrayList<Integer> topo = new ArrayList<>();
        // while(!st.isEmpty()){
        //     topo.add(st.peek());
        //     st.pop();
        // }
        // return topo;
        
        // Using Kahn's algorithm
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i = 0;i < V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
        }
        
        int[] indegree = new int[V];
        
        for(int i = 0;i < V;i++){
            for(int val : adj.get(i)){
                indegree[val]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i < V;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        
        ArrayList<Integer> topo = new ArrayList<>();
        while(!q.isEmpty()){
            int curr = q.poll();
            topo.add(curr);
            
            for(int val : adj.get(curr)){
                indegree[val]--;
                if(indegree[val] == 0) q.add(val);
            }
        
        }
        
        return topo;
    }
}