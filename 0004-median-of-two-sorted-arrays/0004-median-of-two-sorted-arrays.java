class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int k = 0;
        int total= nums1.length + nums2.length;
        int arr[] = new int[nums1.length + nums2.length];
        while(i!=nums1.length && j!=nums2.length){
            if(nums1[i] <= nums2[j]){
                arr[k] = nums1[i];
                i++;
            }
            else{
                arr[k] = nums2[j];
                j++;
            }
            k++;      
        }

        if(i != nums1.length){
            for(int m=i; m<nums1.length; m++){
                arr[k] = nums1[m];
                k++;
            }
        }
         if(j != nums2.length){
            for(int m=j; m<nums2.length; m++){
                arr[k] = nums2[m];
                k++;
            }
        }
        double median = 0;
        if(total % 2 != 0){
            median = arr[((total+1)/2) - 1];
        }
        else
        median = (arr[(total/2)-1] + arr[total/2]) / 2.0;

        return median;    
    }
}