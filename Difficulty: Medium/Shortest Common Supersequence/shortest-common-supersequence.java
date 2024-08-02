//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total testcases
		int t=sc.nextInt();
		
		sc.nextLine();
		while(t-->0)
		{
		   //taking String X and Y
		   String S[]=sc.nextLine().split(" ");
		   String X=S[0];
		   String Y=S[1];
		   
		   //calling function shortestCommonSupersequence()
		   System.out.println(new Solution().shortestCommonSupersequence(X, Y, X.length(), Y.length()));
		}
	}




       
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
      public static String getLCS(String s, String t, int n, int m){
        int[][] dp = new int[n + 1][m + 1];
        
         for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(s.charAt(i - 1) == t.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } 
                else {
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
                if(dp[i - 1][j] > dp[i][j - 1]){
                    i--;
                }
                else{
                    j--;
                }
            }
        }
        
        return ans.reverse().toString();
    }
    //Function to find length of shortest common supersequence of two strings.
    public static int shortestCommonSupersequence(String X,String Y,int m,int n)
    {
        //Your code here
        String LCS = getLCS(X, Y, m, n);
        int length = m + n - LCS.length();
        
        return length;
    }
}