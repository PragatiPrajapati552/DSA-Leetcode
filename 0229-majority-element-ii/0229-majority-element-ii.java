class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int cand1 = 0; 
        int cand2 = 0;
        int count1 = 0;
        int count2 = 0;
        for(int i=0; i <nums.length; i++){
            if(cand1 == nums[i])
            count1++;
            else if(cand2 == nums[i])
            count2++;
            else if(count1 == 0){
                cand1 = nums[i];
                count1++;
            }
            else if(count2 == 0){
                cand2 = nums[i];
                count2++;
            }
            else {
                count1--;
                count2--;
            }
            
        }
        int c1 = 0;
        int c2 = 0;
        for(int  i=0;i<nums.length;i++){
            if(cand1 == nums[i])
            c1++;
            else if(cand2 == nums[i])
            c2++;
        }
        List<Integer> ans = new ArrayList<>();
        int limit = (int)Math.floor(nums.length/3.0);
        if(c1>limit)
        ans.add(cand1);
        if(c2>limit)
        ans.add(cand2);

        return ans;
    }
}