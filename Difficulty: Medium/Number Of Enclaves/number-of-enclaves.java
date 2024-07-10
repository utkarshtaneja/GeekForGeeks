//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(in.readLine());
        while (T-- > 0) {
            String s[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int a[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                s = in.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    a[i][j] = Integer.parseInt(s[j]);
                }
            }
            Solution ob = new Solution();
            out.println(ob.numberOfEnclaves(a));
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static boolean check(int i, int j, int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        
        if(i == 0 || i == n - 1) return true;
        if(j == 0 || j == m - 1) return true;
        
        return false;
    }
    public static void dfs(int row, int col, int[][] vis, int[][] grid){
        vis[row][col] = 1;
        
        int n = grid.length;
        int m = grid[0].length;
        
        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};
        
        for(int i = 0;i < 4;i++){
            int nRow = row + dRow[i];
            int nCol = col + dCol[i];
            
            if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && vis[nRow][nCol] == 0 && grid[nRow][nCol] == 1){
                dfs(nRow, nCol, vis, grid);
            }
        }
    }
    public static int numberOfEnclaves(int[][] grid) {
        // Your code here
        int n = grid.length;
        int m = grid[0].length;
        
        int[][] vis = new int[n][m];
        
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                if(grid[i][j] == 1 && check(i, j, grid)){
                    dfs(i, j, vis, grid);
                }
            }
        }
        
        int ans = 0;
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                if(grid[i][j] == 1 && vis[i][j] == 0){
                    ans++;
                }
            }
        }
        return ans;
    }
}