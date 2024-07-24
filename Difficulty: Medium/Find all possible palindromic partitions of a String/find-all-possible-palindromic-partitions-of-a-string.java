//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();

            Solution ob = new Solution();
            ArrayList<ArrayList<String>> allPart = ob.allPalindromicPerms(S);
            
            for (int i=0; i<allPart.size(); i++)  
            { 
                for (int j=0; j<allPart.get(i).size(); j++) 
                { 
                    System.out.print(allPart.get(i).get(j) + " "); 
                } 
                System.out.println(); 
            } 
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public static boolean isPalindrome(String s){
        int start = 0;
        int end = s.length() - 1;
        
        while(start <= end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public static void generate(String s, int index, int n, ArrayList<ArrayList<String>> ans, ArrayList<String> temp){
        if(index >= n){
            ans.add(new ArrayList<>(temp));
        }
        
        for(int i = index;i < n;i++){
            String str = s.substring(index, i + 1);
            if(isPalindrome(str)){
                temp.add(str);
                generate(s, i + 1, n, ans, temp);
                temp.remove(temp.size() - 1);
            }
        }
        
    }
    public static ArrayList<ArrayList<String>> allPalindromicPerms(String S) {
        // code here
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        int n = S.length();
        
        if(n == 0) return ans;
        
        generate(S, 0, n, ans, new ArrayList<>());
        return ans;
    }
};