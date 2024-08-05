//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            int n = Integer.parseInt(read.readLine());
            String str = read.readLine().strip();
            Solution ob = new Solution();
            long ans = ob.minDeletions(str, n); 
            System.out.println(ans);
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
    int minDeletions(String str, int n)
    {
        // code here
        String t = reverse(str);
        String LCS = getLCS(str, t);
        
        return str.length() - LCS.length();
    }
} 