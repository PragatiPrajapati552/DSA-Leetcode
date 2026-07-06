class Solution {

    public int[] findPeakGrid(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;

        int start = 0;
        int end = n - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            // Find the row having the maximum value in the middle column
            int maxRow = 0;

            for (int i = 1; i < m; i++) {
                if (mat[i][mid] > mat[maxRow][mid]) {
                    maxRow = i;
                }
            }

            int left = (mid > 0) ? mat[maxRow][mid - 1] : -1;
            int right = (mid < n - 1) ? mat[maxRow][mid + 1] : -1;

            if (mat[maxRow][mid] > left && mat[maxRow][mid] > right) {
                return new int[]{maxRow, mid};
            }
            else if (left > mat[maxRow][mid]) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }

        return new int[]{-1, -1};
    }
}