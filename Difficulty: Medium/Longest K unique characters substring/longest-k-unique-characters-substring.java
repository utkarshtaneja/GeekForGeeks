//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        
        // Brute Force
        // int n = s.length();
        // int maxLen = -1;
        
        // for(int i = 0;i < n;i++){
        //     HashMap<Character, Integer> map = new HashMap<>();
        //     for(int j = i;j < n;j++){
        //         char ch = s.charAt(j);
        //         map.put(ch, map.getOrDefault(ch, 0) + 1);
                
        //         if(map.size() <= k){
        //             maxLen = Math.max(maxLen, j - i + 1);
        //         }
        //         else{
        //             break;
        //         }
        //     }
        // }
        // return maxLen;
        
        // Optimal
        if(s.length() == 0 || k <= 0) {
            return -1;
        }
        int l = 0;
        int r = 0;
        int maxLen = -1;
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();
        
        while(r < n){
            char ch = s.charAt(r);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            while(map.size() > k){
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                if(map.get(s.charAt(l)) == 0){
                    map.remove(s.charAt(l));
                }
                l++;
            }
            
            if(map.size() == k) maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        
        return maxLen == -1 ? -1 : maxLen;
        
    }
}