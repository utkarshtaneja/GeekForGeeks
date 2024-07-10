//{ Driver Code Starts
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
            String[] S1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            int[][] image =  new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S2 = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++)
                    image[i][j] = Integer.parseInt(S2[j]);
            }
            String[] S3 = br.readLine().trim().split(" ");
            int sr = Integer.parseInt(S3[0]);
            int sc = Integer.parseInt(S3[1]);
            int newColor = Integer.parseInt(S3[2]);
            Solution obj = new Solution();
            int[][] ans = obj.floodFill(image, sr, sc, newColor);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++)
                    System.out.print(ans[i][j] + " ");
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends


class Solution{
    public static void dfs(int row, int col, int[][] ans, int[][] image, int[][] vis, int init, int nc){
        ans[row][col] = nc;
        
        int n = image.length;
        int m = image[0].length;
        
        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};
        
        for(int i = 0;i < 4;i++){
            int nRow = row + dRow[i];
            int nCol = col + dCol[i];
            
            if(nRow >= 0 && nCol >= 0 && nRow < n && nCol < m && vis[nRow][nCol] == 0 && ans[nRow][nCol] != nc && image[nRow][nCol] == init){
                vis[nRow][nCol] = 1;
                dfs(nRow, nCol, ans, image, vis, init, nc);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor){
        // Code here 
        
        int n = image.length;
        int m = image[0].length;
        
        int init = image[sr][sc];
        
        int[][] vis = new int[n][m];
        int[][] ans = image;
        
        dfs(sr, sc, ans, image, vis, init, newColor);
        
        return ans;
    }
}