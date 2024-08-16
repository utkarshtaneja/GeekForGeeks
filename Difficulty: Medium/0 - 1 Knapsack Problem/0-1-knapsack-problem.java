//{ Driver Code Starts
import java.io.*;
import java.util.*;

class gfg {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int w = Integer.parseInt(br.readLine());

            String line = br.readLine();
            String[] tokens = line.split(" ");
            List<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] val = new int[array.size()];
            int idx = 0;
            for (int i : array) val[idx++] = i;

            String lin = br.readLine();
            String[] toke = lin.split(" ");
            List<Integer> array1 = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : toke) {
                array1.add(Integer.parseInt(token));
            }

            int[] wt = new int[array1.size()];
            idx = 0;
            for (int i : array1) wt[idx++] = i;

            // calling method knapSack() of class Solution
            System.out.println(new Solution().knapSack(w, wt, val));
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to return max value that can be put in knapsack of capacity W.
    // public static int KnapSackRecursive(int W, int n, int[] wt, int[] val){
    //     if(n == 0 || W == 0) return 0;
        
    //     if(wt[n - 1] <= W){
    //         int pick = val[n - 1] + KnapSackRecursive(W - wt[n - 1], n - 1, wt, val);
    //         int notPick = KnapSackRecursive(W, n - 1, wt, val);
            
    //         return Math.max(pick, notPick);
    //     }
        
    //     else{
    //         return KnapSackRecursive(W, n - 1, wt, val);
    //     }
    // }
    
    public static int KnapSackMemoize(int W, int n, int[] wt, int[] val, int[][] dp){
        if(n == 0 || W == 0) return 0;
        
        if(dp[n][W] != -1) return dp[n][W];
        
        if(wt[n - 1] <= W){
            int pick = val[n - 1] + KnapSackMemoize(W - wt[n - 1], n - 1, wt, val, dp);
            int notPick = KnapSackMemoize(W, n - 1, wt, val, dp);
            dp[n][W] = Math.max(pick, notPick);
            return dp[n][W];
        }
        
        else{
            dp[n][W] = KnapSackMemoize(W, n - 1, wt, val, dp);
            return dp[n][W];
        }
    }
    static int knapSack(int W, int wt[], int val[]) {
        // your code here
        
        // Recursive code
        // int n = wt.length;
        // return KnapSack(W, n, wt, val);
        
        // Memoization
        int n = wt.length;
        int[][] dp = new int[n + 1][W + 1];
        
        for(int i = 0;i <= n;i++){
            for(int j = 0;j <= W;j++){
                dp[i][j] = -1;
            }
        }
        return KnapSackMemoize(W, n, wt, val, dp);
    }
}
