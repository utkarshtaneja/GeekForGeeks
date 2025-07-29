class Solution {
    public static boolean possible(int[] arr, int dist, int cows) {
        int count = 1;
        int last = arr[0];
        
        for (int i = 1;i < arr.length;i++) {
            if (arr[i] - last >= dist) {
                count++;
                last = arr[i];
            }
        }
        if (count >= cows) return true;
        return false;
    }
    public int aggressiveCows(int[] stalls, int k) {
        // code here
        // Brute Force
        
        // Arrays.sort(stalls);
        // int min = stalls[0];
        // int max = stalls[stalls.length - 1];
        // int ans = 0;
        
        // for (int i = 1;i <= max - min;i++) {
        //     if (possible(stalls, i, k)) {
        //         ans = i;
        //     }
        // }
        // return ans;
        
        // Optimal
        Arrays.sort(stalls);
        int low = 1;
        int high = stalls[stalls.length - 1] - stalls[0];
        int ans = 0;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (possible(stalls, mid, k)) {
                ans = mid;
                low = mid + 1;
            }
            else{
                high = mid - 1; 
            }    
        }
        return ans;
    }
}