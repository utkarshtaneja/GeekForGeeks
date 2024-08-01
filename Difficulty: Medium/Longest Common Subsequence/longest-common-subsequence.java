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
     public static int LCSUsingMemoization(String s1, int n, String s2, int m, int[][] dp){
        if(n == 0 || m == 0) return 0;
        
        if(dp[n][m] != -1) return dp[n][m];
        
        if(s1.charAt(n - 1) == s2.charAt(m - 1)){
            dp[n][m] = LCSUsingMemoization(s1, n - 1, s2, m - 1, dp) + 1;
            return dp[n][m];
        }
        
        int first = LCSUsingMemoization(s1, n, s2, m - 1, dp);
        int second = LCSUsingMemoization(s1, n - 1, s2, m, dp);
        dp[n][m] = Math.max(first, second);
        return dp[n][m];
    }
    static int lcs(int n, int m, String str1, String str2) {
        // your code here
        
        // Using Recursion
        // if(n == 0 || m == 0) return 0;
        
        // if(str1.charAt(n - 1) == str2.charAt(m - 1)){
        //     return lcs(n - 1, m - 1, str1, str2) + 1;
        // }
        
        // int first = lcs(n , m - 1, str1, str2);
        // int second = lcs(n - 1, m, str1, str2);
        // return Math.max(first, second);
        
        // Using Memoization
        int[][] dp = new int[n + 1][m + 1];
        for(int i = 0;i <= n;i++){
            for(int j = 0;j <= m;j++){
                dp[i][j] = -1;
            }
        }
        
        return LCSUsingMemoization(str1, n, str2, m, dp);
        
        // Using Tabulation
        // if(n == 0 || m == 0) return 0;
        
        // int[][] dp = new int[n + 1][m + 1];
        
        // for(int i = 1;i <= n;i++){
        //     for(int j = 1;j <= m;j++){
        //         if(str1.charAt(i - 1) == str2.charAt(j - 1)){
        //             dp[i][j] = dp[i - 1][j - 1] + 1;   
        //         }
        //         else{
        //             dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        //         }
        //     }
        // }
        
        // return dp[n][m];
    }
}