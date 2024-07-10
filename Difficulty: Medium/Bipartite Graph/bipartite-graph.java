//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int V = Integer.parseInt(S[0]);
            int E = Integer.parseInt(S[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i = 0; i < V; i++){
                adj.add(new ArrayList<Integer>());
            }
            for(int i = 0; i < E; i++){
                String[] s = br.readLine().trim().split(" ");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isBipartite(V, adj);
            if(ans)
                System.out.println("1");
            else System.out.println("0");
       }
    }
}
// } Driver Code Ends

// Using BFS

// class Solution{
//     public static boolean check(int node, int[] color, ArrayList<ArrayList<Integer>>adj){
//         Queue<Integer> q = new LinkedList<>();
//         q.add(node);
//         color[node] = 0;
        
//         while(!q.isEmpty()){
//             int curr = q.poll();
            
//             for(int val : adj.get(curr)){
//                 if(color[val] == -1){
//                     color[val] = 1 - color[curr];
//                     q.add(val);
//                 }
                
//                 else if(color[val] == color[curr]){
//                     return false;
//                 }
//             }
//         }
        
//         return true;
//     }
//     public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj){
//         // Code here
        
//         int[] color = new int[V];
//         Arrays.fill(color, -1);
        
//         for(int i = 0;i < V;i++){
//             if(color[i] == -1){
//                 if(check(i, color, adj) == false){
//                     return false;
//                 }
//             }
//         }
        
//         return true;
//     }
// }

// Using DFS

class Solution{
    public static boolean dfs(int node, int currColor, int[] color, ArrayList<ArrayList<Integer>> adj){
        color[node] = currColor;
        
        for(int curr : adj.get(node)){
            if(color[curr] == -1){
                if(dfs(curr, 1 - currColor, color, adj) == false){
                    return false;
                }
            }
            
            if(color[curr] == currColor){
                return false;
            }
        }
        
        return true;
    }
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj){
        // Code here
        int[] color = new int[V];
        Arrays.fill(color, -1);
        
        for(int i = 0;i < V;i++){
            if(color[i] == -1){
                if(dfs(i, -1, color, adj) == false){
                    return false;
                }
            }
        }
        
        return true;
    }
}