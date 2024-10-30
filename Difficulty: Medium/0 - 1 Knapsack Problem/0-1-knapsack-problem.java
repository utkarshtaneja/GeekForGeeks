//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        while (testCases-- > 0) {
            // Read capacity
            int capacity = Integer.parseInt(br.readLine());

            // Read values
            String[] valInput = br.readLine().split(" ");
            int[] val = new int[valInput.length];
            for (int i = 0; i < valInput.length; i++) {
                val[i] = Integer.parseInt(valInput[i]);
            }

            // Read weights
            String[] wtInput = br.readLine().split(" ");
            int[] wt = new int[wtInput.length];
            for (int i = 0; i < wtInput.length; i++) {
                wt[i] = Integer.parseInt(wtInput[i]);
            }

            // Call the knapSack function and print the result
            System.out.println(Solution.knapSack(capacity, val, wt));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int knapsack(int[] val, int[] wt, int n, int W){
        if(n == 0 || W == 0) return 0;
        
        if(wt[n - 1] <= W){
            int pick = val[n - 1] + knapsack(val, wt, n - 1, W - wt[n - 1]);
            int not_pick = knapsack(val, wt, n - 1, W);
            
            return Math.max(pick, not_pick);
        }
        
        return knapsack(val, wt, n - 1, W);
    }
    // Function to return max value that can be put in knapsack of capacity.
    static int knapSack(int capacity, int val[], int wt[]) {
        // code here
        
        // Using recursion
        int n = val.length;
        return knapsack(val, wt, n, capacity);
    }
}
