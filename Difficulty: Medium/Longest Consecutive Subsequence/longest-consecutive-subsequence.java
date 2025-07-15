class Solution {

    // Function to return length of longest subsequence of consecutive integers.
    // public static boolean linearSearch(int[] arr, int target){
    //     boolean found = false;
    //     for (int val : arr) {
    //         if (target == val) {
    //             found = true;
    //             break;
    //         }
    //     }
    //     return found;
    // }
    public int longestConsecutive(int[] arr) {
        // code here
        // Brute Force
        // int n = arr.length;
        // int max = 1;
        // for (int i = 0;i < n;i++) {
        //     int x = arr[i];
        //     int count = 1;
            
        //     while (linearSearch(arr, x + 1) == true) {
        //         x++;
        //         count++;
        //     }
            
        //     max = Math.max(count, max);
        // }
        // return max;
        
        // Better
        int n = arr.length;
        Arrays.sort(arr);
        int longest = 1;
        int curr = 0;
        int ls = Integer.MIN_VALUE;
        
        for (int i = 0;i < n;i++) {
            if (arr[i] - 1 == ls) {
                curr++;
                ls = arr[i];
            }
            else if (arr[i] != ls) {
                curr = 1;
                ls = arr[i];
            }
            longest = Math.max(longest, curr);
        }
        return longest;
    }
}