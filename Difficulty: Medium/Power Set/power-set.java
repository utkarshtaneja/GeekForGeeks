//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine().trim();
            Solution ob = new Solution();
            List<String> ans = ob.AllPossibleStrings(s);
            for(String i: ans)
                System.out.print(i + " ");
            System.out.println();
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static void generate(String s, String curr, int index, List<String> list){
        if(index == s.length()){
            if(!curr.isEmpty()) list.add(curr);
            return;
        }
        
        generate(s, curr + s.charAt(index), index + 1, list);
        generate(s, curr, index + 1, list);
    }
    public List<String> AllPossibleStrings(String s)
    {
        // Code here
        List<String> list = new ArrayList<>();
        generate(s, "", 0, list);
        Collections.sort(list);
        return list;
    }
}