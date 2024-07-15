//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            int m = Integer.parseInt(br.readLine().trim());

            int ans = new Solve().findZeroes(arr, n, m);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solve {
    // m is maximum of number zeroes allowed to flip
    int findZeroes(int arr[], int n, int m) {
        // code here
        // Brute Force
        // int ans = 0;
        // for(int i = 0;i < n;i++){
        //     int zeroes = 0;
        //     for(int j = i;j < n;j++){
        //         if(arr[j] == 0) zeroes++;
        //         if(zeroes > m) {
        //             break;
        //         }
        //         ans = Math.max(ans, j - i + 1);
        //     }
        // }
        // return ans;
        
        // Optimal
        int l = 0;
        int r = 0;
        int maxLen = 0;
        int len = 0;
        int zeroes = 0;
        
        while(r < n){
            if(arr[r] == 0){
                zeroes++;
            }
            while(zeroes > m){
                if(arr[l] == 0) zeroes--;
                l++;
            }
            
            if(zeroes <= m){
                len = r - l + 1;
                maxLen = Math.max(maxLen, len);
            }
            r++;
        }
        return maxLen;
    }
}