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
        
        for(int x : adj.get(curr)){
            if(vis[x] == false){
                dfs(x, vis, adj);
            }
        }
    }
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        
        for(int i = 0;i < V;i++){
            list.add(new ArrayList<>());
        }
        
        for(int i = 0;i < V;i++){
            for(int j = 0;j < V;j++){
                if(adj.get(i).get(j) == 1 && i != j){
                    list.get(i).add(j);
                    list.get(j).add(i);
                }
            }
        }
        
        boolean[] vis = new boolean[V + 1];
        int count = 0;
        
        for(int i = 0;i < V;i++){
            if(vis[i] == false){
                count++;
                dfs(i, vis, list);
            }
        }
        
        return count;
    }
};