class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int nge[] = new int[nums2.length];
        int ans[] = new int[nums1.length];
        int n1 = nums1.length-1;
        int n2 = nums2.length-1;
        Stack<Integer> s = new Stack<>();
        s.push(nums2[n2]);
        nge[n2] = -1;
        for(int i=nums2.length-2; i>=0; i--){
            int curr = nums2[i];
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
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                if(nums1[i] == nums2[j]){
                    ans[i] = nge[j];
                }
            }
        }
        return ans;
    }
}