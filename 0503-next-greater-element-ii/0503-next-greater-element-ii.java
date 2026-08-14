class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int cir = nums.length*2;
        int arr[] = new int[cir];
        for(int i=0;i<nums.length;i++){
            arr[i] = nums[i];
        }
        int j = 0;
        for(int i=nums.length;i<cir;i++){
            arr[i] = nums[j];
            j++;
        }
        int nge[] = new int[cir];
        Stack<Integer> s = new Stack<>();
        for(int i=arr.length-1; i>=0; i--){
            int curr = arr[i];
            while(!s.isEmpty() && curr >= s.peek() ){
                s.pop();
            }
            if(s.isEmpty()){
                nge[i] = -1;
            }
            else{
                nge[i] = s.peek();
            }
            s.push(curr);
        }
        int ans[] = new int[nums.length];
        for(int i = 0; i<ans.length;i++)
        ans[i] = nge[i];

        return ans;
    }
}