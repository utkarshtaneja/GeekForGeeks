//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String line1[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(line1[0]);
            int W = Integer.parseInt(line1[1]);
            String line2[] = in.readLine().trim().split("\\s+");
            int val[] = new int[N];
            for(int i = 0;i < N;i++)
                val[i] = Integer.parseInt(line2[i]);
            String line3[] = in.readLine().trim().split("\\s+");
            int wt[] = new int[N];
            for(int i = 0;i < N;i++)
                wt[i] = Integer.parseInt(line3[i]);
                
            Solution ob = new Solution();
            System.out.println(ob.knapSack(N, W, val, wt));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int knapSack(int N, int W, int val[], int wt[])
    {
        // code here
        
        // Using Recusrsion
        // if(N == 0 || W == 0) return 0;
        
        // if(wt[N - 1] <= W){
        //     int include = val[N - 1] + knapSack(N, W - wt[N - 1], val, wt);
        //     int notinclude = knapSack(N - 1, W, val, wt);
            
        //     return Math.max(include, notinclude);
        // }
        
        // else{
        //     return knapSack(N - 1, W, val, wt);
        // }
        
        // Using Memoization
        int[][] dp = new int[N + 1][W + 1];
        
        for(int i = 0;i <= N;i++){
            for(int j = 0;j <= W;j++){
                dp[i][j] = 0;
            }
        }
        
        return knapSackUtil(N, W, val, wt, dp);
    }
    // Memoization Dp
    public static int knapSackUtil(int N, int W, int val[], int wt[], int[][] dp) {
        if(N == 0 || W == 0) return 0;
        
        if(dp[N][W] != 0) return dp[N][W];
        if(wt[N - 1] <= W){
            int include = val[N - 1] + knapSackUtil(N, W - wt[N - 1], val, wt, dp);
            int notinclude = knapSackUtil(N - 1, W, val, wt, dp);
            dp[N][W] = Math.max(include, notinclude);
            return dp[N][W];
        }
        
        else{
            dp[N][W] = knapSackUtil(N - 1, W, val, wt, dp);
            return dp[N][W];
        }
    }
}