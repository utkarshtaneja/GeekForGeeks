// User function Template for Java

class Solution {
    public static int requiredGasStations(double dist, int[] arr) {
        int count = 0;
        for (int i = 1; i < arr.length; i++) {
            double gap = arr[i] - arr[i - 1];
            count += (int)(gap / dist);
        }
        return count;
    }
    public static double findSmallestMaxDist(int stations[], int k) {
        // code here
        // Brute Force
        
        // int n = stations.length;
        // int[] howMany = new int[n - 1];
        // Arrays.fill(howMany, 0);
        
        // for (int i = 1;i <= k;i++) {
        //     double maxVal = -1;
        //     int maxIndex = -1;
            
        //     for (int j = 0;j < n - 1;j++) {
        //         double diff = stations[j + 1] - stations[j];
        //         double sectionLength = diff / (double) (howMany[j] + 1);
                
        //         if (maxVal < sectionLength) {
        //             maxVal = sectionLength;
        //             maxIndex = j;
        //         }
        //     }
            
        //     howMany[maxIndex]++;
        // }
        
        // double maxAns = -1;
        
        // for (int i = 0;i < n - 1;i++) {
        //     double diff = stations[i + 1] - stations[i];
        //     double sectionLength = diff / (double) (howMany[i] + 1);
        //     maxAns = Math.max(maxAns, sectionLength);
        // }
        
        // return maxAns;
        
        // Optimal
        int n = stations.length;
        double low = 0;
        double high = 0;
        
        for (int i = 0;i < n - 1;i++) {
            high = Math.max(high, (stations[i + 1] - stations[i]));
        }
        
        double diff = 1e-6;
        while (high - low > diff) {
            double mid = low + (high - low) / 2;
            int count = requiredGasStations(mid, stations);
            if (count > k) {
                low = mid;
            }
            else {
                high = mid;
            }
        }
        return high;
    }
}
