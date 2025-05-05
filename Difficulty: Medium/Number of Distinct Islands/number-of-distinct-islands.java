//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static void dfs(int row, int col, boolean[][] vis, int[][] grid, List<String> list, int row0, int col0){
        vis[row][col] = true;
        list.add(toString(row0 - row, col0 - col));
        int n = grid.length;
        int m = grid[0].length;
        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};
        for(int i = 0;i < 4;i++){
            int nRow = row + dRow[i];
            int nCol = col + dCol[i];
            
            if(nRow >= 0 && nCol >= 0 && nRow < n && nCol < m && !vis[nRow][nCol] && grid[nRow][nCol] == 1){
                dfs(nRow, nCol, vis, grid, list, row0, col0);
            }
        }
    }
    public static String toString(int row, int col){
        return Integer.toString(row) + " " + Integer.toString(col);
    }
    int countDistinctIslands(int[][] grid) {
        // Your Code here
        Set<List<String>> set = new HashSet<>();
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                if(!vis[i][j] && grid[i][j] == 1){
                    List<String> temp = new ArrayList<>();
                    dfs(i, j, vis, grid, temp, i, j);
                    set.add(temp);
                }
            }
        }
        return set.size();
    }
}
