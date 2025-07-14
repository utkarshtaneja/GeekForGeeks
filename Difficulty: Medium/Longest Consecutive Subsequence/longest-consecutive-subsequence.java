class Solution {

    // Function to return length of longest subsequence of consecutive integers.
    public static boolean linearSearch(int[] arr, int target){
        boolean found = false;
        for (int val : arr) {
            if (target == val) {
                found = true;
                break;
            }
        }
        return found;
    }
    public int longestConsecutive(int[] arr) {
        // code here
        // Brute Force
        int n = arr.length;
        int max = 1;
        for (int i = 0;i < n;i++) {
            int x = arr[i];
            int count = 1;
            
            while (linearSearch(arr, x + 1) == true) {
                x++;
                count++;
            }
            
            max = Math.max(count, max);
        }
        return max;
    }
}