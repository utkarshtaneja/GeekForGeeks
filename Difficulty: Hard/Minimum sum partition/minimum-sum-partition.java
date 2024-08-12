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
    public static boolean[][] SubsetSum(int[] arr, int n, int sum){
        boolean[][] dp = new boolean[n + 1][sum + 1];
        
        for(int i = 0;i <= n;i++){
            for(int j = 0;j <= sum;j++){
                if(i == 0) dp[i][j] = false;
                if(j == 0) dp[i][j] = true;
            }
        }
        
        for(int i = 1;i <= n;i++){
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
	    for(int num : arr){
	        sum += num;
	    }
	    
	    int target = sum / 2;
	    boolean[][] dp = SubsetSum(arr, n, target);
	    
	    int max = 0;
	    
	    for(int i = target;i >= 0;i--){
	        if(dp[n][i]){
	            max = i;
	            break;
	        }
	    }
	    
	    int S1 = max;
	    int S2 = sum - S1;
	    
	    return Math.abs(S2 - S1);
	} 
}
