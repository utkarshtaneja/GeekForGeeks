//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public static void dfs(int curr, boolean[] vis, ArrayList<ArrayList<Integer>> adj){
        vis[curr] = true;
        
        for(int val : adj.get(curr)){
            if(!vis[val]){
                dfs(val, vis, adj);
            }
        }
    }
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        
        for(int i = 0;i < V;i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i = 0;i < V;i++){
            for(int j = 0;j < V;j++){
                if(adj.get(i).get(j) == 1 && i != j){
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }
        
        boolean[] vis = new boolean[V + 1];
        int count = 0;
        
        for(int i = 0;i < V;i++){
            if(vis[i] == false){
                count++;
                dfs(i, vis, graph);
            }
        }
        
        return count;
    }
};