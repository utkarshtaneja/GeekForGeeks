//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            //br.readLine();
            String s;
            s = br.readLine();
            
            Solution obj = new Solution();
            int res = obj.countSubstring(s);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int countSubstring(String s) {
        // Brute Force
        // int n = s.length();
        // int count = 0;
        // int aCount = 0, bCount = 0, cCount = 0;
        
        // for(int i = 0; i < n; i++){
        //     aCount = 0; bCount = 0; cCount = 0;
        //     for(int j = i; j < n; j++){
        //         if(s.charAt(j) == 'a') aCount++;
        //         if(s.charAt(j) == 'b') bCount++;
        //         if(s.charAt(j) == 'c') cCount++;
                
        //         if(aCount > 0 && bCount > 0 && cCount > 0) count++;
        //     }
        // }
        // return count;
        
        // Optimal
        int n = s.length();
        int[] lastseen = new int[] {-1, -1, -1};
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            char ch = s.charAt(i);
            lastseen[ch - 'a'] = i;
            ans += Math.min(lastseen[0], Math.min(lastseen[1], lastseen[2])) + 1;
        }
        return ans;
    }
}    
