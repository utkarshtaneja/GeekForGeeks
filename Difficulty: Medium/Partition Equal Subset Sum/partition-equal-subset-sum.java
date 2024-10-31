//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            Solution ob = new Solution();

            if (ob.equalPartition(arr))
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static boolean isPossible(int[] arr, int n, int sum){
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
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                }
                else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        
        return dp[n][sum];
    }
    static boolean equalPartition(int arr[]) {
        // code here
        int sum = 0;
        int n = arr.length;
        for(int num : arr){
            sum += num;
        }
        
        if(sum % 2 != 0) return false;
        return isPossible(arr, n, sum / 2);
    }
}