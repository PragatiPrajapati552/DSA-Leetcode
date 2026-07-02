class Solution {
    public boolean check(int[] nums) {
        int arr[] =  new int[nums.length];
        int idx = -1;
        for(int i =0; i<nums.length-1;i++){
            if(nums[i] > nums[i+1]){
            idx = i+1;
            break;
            }  
        }

        if(idx == -1)
        return true;

        int id = 0;
        for(int i=0;i<nums.length;i++){
            if(idx != nums.length){
            arr[i] = nums[idx];
            idx++;
            }
            else {
                arr[i] = nums[id];
                id++;
            }   
        }
        
        for(int i=0; i<nums.length-1;i++){
            if(arr[i] > arr[i+1])
            return false;    
        }
        return true;
    }
}