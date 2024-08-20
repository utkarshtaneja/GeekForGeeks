//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            int n = sc.nextInt(); // Take size of both the strings as input
            int m = sc.nextInt();

            String str1 = sc.next(); // Take both the string as input
            String str2 = sc.next();

            Solution obj = new Solution();

            System.out.println(obj.lcs(n, m, str1, str2));
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to find the length of longest common subsequence in two strings.
    static int lcs(int n, int m, String str1, String str2) {
        // your code here
        
        // Using recursion
        // if(n == 0 || m == 0) return 0;
        
        // if(str1.charAt(n - 1) == str2.charAt(m - 1)){
        //     return 1 + lcs(n - 1, m - 1, str1, str2);   
        // }
        
        // else{
        //     return Math.max(lcs(n - 1, m, str1, str2), lcs(n, m - 1, str1, str2));
        // }
        
        // Using Memoization
        int[][] dp = new int[n + 1][m + 1];
        
        for(int i = 0;i <= n;i++){
            for(int j = 0;j <= m;j++){
                dp[i][j] = -1;
            }
        }
        
        return LCS_Memo(n, m, str1, str2, dp);
    }
    
    public static int LCS_Memo(int n, int m, String str1, String str2, int[][] dp){
        if(n == 0 || m == 0) return 0;
        
        if(dp[n][m] != -1) return dp[n][m];
        
        if(str1.charAt(n - 1) == str2.charAt(m - 1)){
            dp[n][m] = 1 + LCS_Memo(n - 1, m - 1, str1, str2, dp);
            return dp[n][m];   
        }
        
        else{
            dp[n][m] = Math.max( LCS_Memo(n - 1, m, str1, str2, dp), 
                                 LCS_Memo(n, m - 1, str1, str2, dp) );
            return dp[n][m];
        }
    }
}