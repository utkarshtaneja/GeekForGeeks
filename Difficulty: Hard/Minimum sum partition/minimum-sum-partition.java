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
                    int n = sc.nextInt();
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{   
    public static boolean[][] isSubsetSum(int N, int arr[], int sum){
        boolean[][] dp = new boolean[N + 1][sum + 1];
        
        for(int i = 0;i <= N;i++){
            for(int j = 0;j <= sum;j++){
                if(i == 0) dp[i][j] = false;
                if(j == 0) dp[i][j] = true;
            }
        }
        
        for(int i = 1;i <= N;i++){
            for(int j = 1;j <= sum;j++){
                if(arr[i - 1] <= j){
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                }
                else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp;
    }

	public int minDifference(int arr[], int n) 
	{ 
	    // Your code goes here
	    int sum = 0;
	    
	    for(int i = 0;i < n;i++){
	        sum += arr[i];
	    }
	    
	    boolean[][] dp = isSubsetSum(n, arr, sum);
	    
	    int target = sum / 2;
	    int maxSubsetSum = 0;
	    
	    for(int i = target; i >= 0; i--){
            if(dp[n][i]){
                maxSubsetSum = i;
                break;
            }
        }
	    
	    int sum1 = maxSubsetSum;
        int sum2 = sum - sum1;
        
        return Math.abs(sum2 - sum1);
	    
	} 
}
