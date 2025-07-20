class Solution {
    static int count;

    public static void merge(int[] arr, int start, int mid, int end) {
        int[] ans = new int[end - start + 1];

        int i = start;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                ans[k++] = arr[i++];
            } else {
                count += (mid - i + 1);
                ans[k++] = arr[j++]; 
            }
        }

        while (i <= mid) ans[k++] = arr[i++];
        while (j <= end) ans[k++] = arr[j++];

        for (int p = 0; p < ans.length; p++) {
            arr[start + p] = ans[p];
        }
    }

    public static void mergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    static int inversionCount(int arr[]) {
        count = 0; 
        mergeSort(arr, 0, arr.length - 1);
        return count;
    }
}
