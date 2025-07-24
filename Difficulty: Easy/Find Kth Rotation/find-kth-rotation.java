class Solution {
    public int findKRotation(List<Integer> arr) {
        // Code here
        int ans = Integer.MAX_VALUE;
        int low = 0;
        int high = arr.size() - 1;
        int index = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr.get(low) <= arr.get(high)) {
                if (arr.get(low) < ans){
                    index = low;
                    ans = arr.get(low);
                }
            }

            if (arr.get(low) <= arr.get(mid)) {
                if (arr.get(low) < ans){
                    index = low;
                    ans = arr.get(low);
                }
                low = mid + 1;
            }
            else {
                if (arr.get(mid) < ans){
                    index = mid;
                    ans = arr.get(mid);
                }
                high = mid - 1;
            }
        }
        return index;
    }
}