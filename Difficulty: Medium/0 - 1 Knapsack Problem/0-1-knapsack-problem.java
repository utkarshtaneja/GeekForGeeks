//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            //calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}




// } Driver Code Ends


class Solution 
{   
    public static int knapSackUtil(int W, int[] wt, int[] val, int n, int[][] dp){
        if(n == 0 || W == 0){
            return 0;
        }
        
        if(dp[n][W] != -1) return dp[n][W];
        
        if(wt[n - 1] <= W){
            int include = val[n - 1] + knapSackUtil(W - wt[n - 1], wt, val, n - 1, dp);
            int notInclude = knapSackUtil(W, wt, val, n - 1, dp);
            dp[n][W] = Math.max(include, notInclude);
            return dp[n][W];
        }
        
        else{
            dp[n][W] = knapSackUtil(W, wt, val, n - 1, dp);
            return dp[n][W];
        }
    }
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
        // Using Recursion
        // if(n == 0 || W == 0){
        //     return 0;
        // }
        
        // if(wt[n - 1] <= W){
        //     int include = val[n - 1] + knapSack(W - wt[n - 1], wt, val, n - 1);
        //     int notInclude = knapSack(W, wt, val, n - 1);
        //     return Math.max(include, notInclude);
        // }
        
        // else{
        //     return knapSack(W, wt, val, n - 1);
        // }
        
        // Using Dp -> Memoization
        int[][] dp = new int[n + 1][W + 1];
        for(int i = 0;i <= n;i++){
            for(int j = 0;j <= W;j++){
                dp[i][j] = -1;
            }
        }
        
        return knapSackUtil(W, wt, val, n, dp);
        
        // if(W <= 0 || n <= 0) return 0;
        
        // int[][] dp = new int[n + 1][W + 1];
        // for(int i = 1;i <= n;i++){
        //     for(int j = 1;j <= W;j++){
        //         dp[i][j] = dp[i - 1][j];
        //         if(wt[i - 1] <= j){
        //             dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - wt[i - 1]] + val[i - 1]);
        //         }
        //     }
        // }
        
        // return dp[n][W];
    } 
}


