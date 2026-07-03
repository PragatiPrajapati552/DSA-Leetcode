class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int sum=0;
        for(int i=0; i<weights.length; i++){
            sum += weights[i];
        }
        int maxm = Integer.MIN_VALUE;
        for(int i=0;i<weights.length;i++){
            maxm = Math.max(maxm, weights[i]);
        }
        int min = maxm;
        int max = sum;
        int ans = 0;
        while(min <= max){
            int mid = (min + max)/2;
            int day = 0;
            int s=0;
            for(int i = 0; i<weights.length;i++){
                if((s + weights[i]) <= mid)
                s += weights[i];
                else{
                    day++;
                    s=0;
                    i--;
                }
            }
            if(s<=mid)
            day++;

            if(day <= days){        //cause in que its asked within not exact days.
                ans = mid;
                max = mid-1;
            }
            else if(day < days)
            max = mid-1;
            else
            min = mid+1;
        }
        return ans;

    }
}