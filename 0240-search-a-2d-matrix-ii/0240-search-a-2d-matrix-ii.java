class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length-1;
        int col = 0;
        while(row >=0 && col<=matrix[0].length-1){
            
            if(matrix[row][col] == target)
            return true;
            else if(matrix[row][col] < target)      //moving right if value is low
            col++;
            else        //moving up if vlaue is higher, cause if first is bigger then it won't be in that row
            row--;
        }
        return false;
    }
}