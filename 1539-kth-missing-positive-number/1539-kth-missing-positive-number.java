class Solution {
    public int findKthPositive(int[] arr, int k) {
        int start = arr[0];
        int num[] = new int[k];
        int n=0;
        for(int i=1; i<start; i++){
            if(n!=k){
            num[n] = i;
            n++;
            }
            else
            break;
        }

        int j=0; //traverse through arr
        for(int i=arr[0]; i<arr[arr.length-1]; i++){
            if(i == arr[j]){
                j++;
            }
            else if(n!=k){
                num[n] = i;
                n++;
            }
            else if(n == k)
            break;
        }
        for(int i = arr[arr.length-1]+1; ; i++ ){
            if(n==k)
            break;
            num[n] = i;
            n++;
        }

        return num[k-1];
    }
}