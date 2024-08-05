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
                    String s1 = sc.next();
                    String s2 = sc.next();
                    Solution ob = new Solution();
                    System.out.println(ob.minOperations(s1,s2));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static String getLcs(String a, String b){
        int n = a.length();
        int m = b.length();
        
        int[][] dp = new int[n + 1][m + 1];
        
        for(int i = 1;i <= n;i++){
            for(int j = 1;j <= m;j++){
                if(a.charAt(i - 1) == b.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else{
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        
        StringBuilder ans = new StringBuilder();
        int i = n;
        int j = m;
        
        while(i > 0 && j > 0){
            if(a.charAt(i - 1) == b.charAt(j - 1)){
                ans.append(a.charAt(i - 1));
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
	public int minOperations(String str1, String str2) 
	{ 
	    // Your code goes here
	    String LCS = getLcs(str1, str2);
	    int del = str1.length() - LCS.length();
	    int ins = str2.length() - LCS.length();
	    return del + ins;
	} 
}