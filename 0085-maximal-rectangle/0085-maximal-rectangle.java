class Solution {
    public int maxArea(int height[]){
        Stack<Integer> s = new Stack<>();
        int n = height.length;
        int max = 0;
        for(int i =0;i<=n;i++){
            int curr = i == n ? 0 : height[i]; //to put 6 when no smaller right
            while(!s.isEmpty() && height[s.peek()] > curr){
                int ht = height[s.pop()];
                int r = i;
                int l = s.isEmpty() ? -1 : s.peek(); //to put -1 when no smaller on left
                int wid = r - l - 1;

                max = Math.max(max, wid*ht);
            }
            s.push(i);
        }
        return max;
    }
    public int maximalRectangle(char[][] matrix) {
        int height[] = new int[matrix[0].length];
        int max  = 0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j] == '1')
                height[j] = height[j] + 1;
                else
                height[j] = 0;
            }
            max = Math.max(max, maxArea(height));
        }
        return max;
    }
}