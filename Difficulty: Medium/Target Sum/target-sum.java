//{ Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            
            int[] A = new int[N];
            
            for(int i=0 ; i<N ; i++){
                A[i] = Integer.parseInt(S[i]);
            }
            int target = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.findTargetSumWays(N,A, target));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public static int isSubsetSum(int[] arr, int n, int sum){
        int[][] dp = new int[n + 1][sum + 1];
        int mod = 1000000007;
        
        for(int i = 0;i <= n;i++){
            for(int j = 0;j <= sum;j++){
                if(i == 0) dp[i][j] = 0;
                if(j == 0) dp[i][j] = 1;
            }
        }
        
        for(int i = 1;i <= n;i++){
            for(int j = 0;j <= sum;j++){
                if(arr[i -1] <= j){
                    dp[i][j] = (dp[i - 1][j - arr[i - 1]] + dp[i - 1][j]) % mod;
                }
                else{
                    dp[i][j] = (dp[i - 1][j]) % mod;
                }
            }
        }
        
        return dp[n][sum];
    }
    public static int countPartitions(int n, int d, int[] arr) {
        // code here
        int sum = 0;
        
        for(int num : arr){
            sum += num;
        }
        
        if((d + sum) % 2 != 0) return 0;
        
        int target = (d + sum) / 2;
        
        if(target < 0 || target > sum) return 0;
        
        return isSubsetSum(arr, n, target);
    }
    static int findTargetSumWays( int N, int[] A ,int target) {
        // code here
        return countPartitions(N, target, A);
    }
};