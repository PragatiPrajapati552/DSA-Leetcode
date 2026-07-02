class Solution {
    public boolean check(int[] nums) {

        int n = nums.length;
        int[] arr = new int[n];

        int idx = -1;

        // Find rotation point
        for(int i = 0; i < n - 1; i++) {
            if(nums[i] > nums[i + 1]) {
                idx = i + 1;
                break;
            }
        }

        // Already sorted
        if(idx == -1)
            return true;

        int start = idx;
        int id = 0;

        // Rotate the array
        for(int i = 0; i < n; i++) {
            if(start < n) {
                arr[i] = nums[start++];
            } else {
                arr[i] = nums[id++];
            }
        }

        // Check if rotated array is sorted
        for(int i = 0; i < n - 1; i++) {
            if(arr[i] > arr[i + 1])
                return false;
        }

        return true;
    }
}