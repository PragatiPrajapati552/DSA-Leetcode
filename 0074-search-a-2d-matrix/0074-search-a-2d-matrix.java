class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int sB = 0; // index for outer - row
        int eB = matrix.length-1;
        if(matrix.length == 1 && matrix[0][0] == target)
        return true;
        int m= matrix.length-1;
        int n=matrix[0].length-1;

        
        while(sB < eB){
            int midB = (sB + eB)/2;
            if(matrix[midB][0] == target || matrix[midB][n] == target )
            return true;
            else if(matrix[midB][0] < target){
                if(matrix[midB][n] > target)
                sB = eB = midB;
                else
                sB = midB+1;
            }
            else
            eB = midB - 1;
        }
        int s = 0;
        int e = matrix[0].length -1;
        while (s<=e){
            int mid = (s+e)/2;
            if(matrix[sB][mid] == target)
            return true;
            else if(matrix[sB][mid] < target)
            s = mid+1;
            else 
            e = mid-1;
        }
        return false;
        
    }
}