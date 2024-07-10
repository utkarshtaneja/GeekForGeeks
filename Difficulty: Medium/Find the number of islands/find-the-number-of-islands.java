//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    public static void dfs(int row, int col, char[][] grid, int[][] vis){
        vis[row][col] = 1;
        
        int n = grid.length;
        int m = grid[0].length;
        
        for(int dRow = -1;dRow <= 1;dRow++){
            for(int dCol = -1;dCol <= 1;dCol++){
                int nRow = row + dRow;
                int nCol = col + dCol;
                
                if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && vis[nRow][nCol] == 0 && grid[nRow][nCol] == '1'){
                    dfs(nRow, nCol, grid, vis);
                }
            }
        }
    }
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        
        int[][] vis = new int[n][m];
        
        int count = 0;
        
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                if(grid[i][j] == '1' && vis[i][j] == 0){
                    count++;
                    dfs(i, j, grid, vis);
                }
            }
        }
        
        return count;
    }
}