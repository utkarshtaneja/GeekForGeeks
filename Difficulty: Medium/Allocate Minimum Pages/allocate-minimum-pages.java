class Solution {
    public static int getNoOfStudents(int[] arr, int pages) {
        int students = 1;
        int pagesOfStudent = 0;
        
        for (int i = 0;i < arr.length;i++) {
            if (pagesOfStudent + arr[i] <= pages) {
                pagesOfStudent += arr[i];
            }
            else {
                students++;
                pagesOfStudent = arr[i];
            }
        }
        return students;
    }
    public int findPages(int[] arr, int k) {
        // code here
        // Brute Force
        
        // if (k > arr.length) return -1;

        // int low = Integer.MIN_VALUE;
        // int high = 0;
        
        // for (int val : arr) {
        //     low = Math.max(low, val);
        //     high += val;
        // }
        
        // for (int i = low;i <= high;i++) {
        //     int count = getNoOfStudents(arr, i);
        //     if (count <= k) return i;
        // }
        // return -1;
        
        // Optimal
        if (k > arr.length) return -1;

        int low = Integer.MIN_VALUE;
        int high = 0;
        
        for (int val : arr) {
            low = Math.max(low, val);
            high += val;
        }
        
        
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int count = getNoOfStudents(arr, mid);
            if (count <= k) {
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
}