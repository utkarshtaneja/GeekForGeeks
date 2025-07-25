// User function Template for Java

class Solution {
    public int nthRoot(int n, int m) {
        // code here
        int low = 1;
        int high = m;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (Math.pow(mid, n) == m) {
                ans = mid;
                break;
            }
            if (Math.pow(mid, n) < m) {
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        } 

        return ans;
    }
}