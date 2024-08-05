//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Solution obj = new Solution();
                    System.out.println(obj.longestPalinSubseq(s));
                }
                
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static String getLCS(String s, String t){
        int n = s.length();
        int m = t.length();
        
        int[][] dp = new int[n + 1][m + 1];
        for(int i = 1;i <= n;i++){
            for(int j = 1;j <= m;j++){
                if(s.charAt(i - 1) == t.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        StringBuilder ans = new StringBuilder();
        
        int i = n;
        int j = m;
        
        while(i > 0 && j > 0){
            if(s.charAt(i - 1) == t.charAt(j - 1)){
                ans.append(s.charAt(i - 1));
                i--;
                j--;
            }
            else{
                if(dp[i][j - 1] > dp[i - 1][j]){
                    j--;
                }
                else{
                    i--;
                }
            }
        }
        
        return ans.reverse().toString();
    }
    public static String reverse(String s){
        String ans = "";
        
        for(int i = 0;i < s.length();i++){
            ans = s.charAt(i) + ans;
        }
        
        return ans;
    }
    public int longestPalinSubseq(String S)
    {
        //code here
        String T = reverse(S);
        
        String LCS = getLCS(S, T);
        return LCS.length();
    }
}