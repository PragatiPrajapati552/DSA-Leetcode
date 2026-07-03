class Solution {
    public int shipWithinDays(int[] weights, int days) {

        int sum = 0;
        int maxWeight = 0;

        for(int w : weights){
            sum += w;
            maxWeight = Math.max(maxWeight, w);
        }

        int min = maxWeight;
        int max = sum;
        int ans = sum;

        while(min <= max){

            int mid = min + (max - min)/2;

            int day = 1;
            int load = 0;

            for(int w : weights){

                if(load + w <= mid){
                    load += w;
                }else{
                    day++;
                    load = w;
                }

            }

            if(day <= days){
                ans = mid;
                max = mid - 1;
            }else{
                min = mid + 1;
            }

        }

        return ans;
    }
}