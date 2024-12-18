//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GfG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            // Read values array
            String[] valueInput = br.readLine().trim().split(" ");
            List<Integer> values = new ArrayList<>();
            for (String s : valueInput) {
                values.add(Integer.parseInt(s));
            }

            // Read weights array
            String[] weightInput = br.readLine().trim().split(" ");
            List<Integer> weights = new ArrayList<>();
            for (String s : weightInput) {
                weights.add(Integer.parseInt(s));
            }

            // Read the knapsack capacity
            int w = Integer.parseInt(br.readLine().trim());

            // Call fractionalKnapsack function and print result
            System.out.println(String.format(
                "%.6f", new Solution().fractionalKnapsack(values, weights, w)));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    static class Pair{
        int first;
        double second;
        
        public Pair(int first, double second){
            this.first = first;
            this.second = second;
        }
    }
    // Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(List<Integer> val, List<Integer> wt, int capacity) {
        // code here
        int n = val.size();
        ArrayList<Pair> list = new ArrayList<>();
        
        for(int i = 0;i < n;i++){
            double perUnitValue = (1.0 * val.get(i)) / wt.get(i);
            list.add(new Pair(i, perUnitValue));
        }
        
        Collections.sort(list, (a, b) -> Double.compare(b.second, a.second));
        
        double total = 0;
        
        for(int i = 0;i < n;i++){
            int index = list.get(i).first;
            
            if(wt.get(index) <= capacity){
                total += val.get(index);
                capacity -= wt.get(index);
            }
            
            else{
                total += (capacity * list.get(i).second);
                break;
            }
        }
        
        return total;
    }
}