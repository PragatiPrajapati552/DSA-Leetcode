class Solution {
    public int longestOnes(int[] nums, int k) {
        int c1 = 0;
        int c0 = 0;
        int i = 0;
        int max = 0;
        for(int j = 0; j<nums.length;j++){

            if(nums[j] == 1)
                c1++;
                else
                c0++;
            while(c0 > k){
                if(nums[i] == 0)
                c0--;

                i++;
            }
            max = Math.max(max, j-i+1);
        }
        return max;
    }
}