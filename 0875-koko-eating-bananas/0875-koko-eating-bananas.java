// class Solution {
//     public int minEatingSpeed(int[] piles, int h) {
        
//         int s = 1;
//         int max = Integer.MIN_VALUE;
//         for(int i =0; i<piles.length;i++){
//             max = Math.max(max,piles[i]);
//         }
//         int e = max;
//         int c = 0;
//         while(s<=e){
//             int mid = (s+e)/2;
//             int arr[] = new int[piles.length];
//             for(int i =0; i<piles.length;i++){
//             arr[i ]= piles[i];
//             }
//             for(int i=0;i<arr.length;i++){
//                 if(arr[i] <= mid)
//                 c++;
//                 else {
//                     arr[i] -= mid;
//                     c++;
//                     i--;
//                 }
//             }
//             if(c == h)
//             return mid;
//             else if(c < h)
//             e = mid-1;
//             else 
//             s = mid+1;   

//             c=0; 
//         }

     
        
//     }
// }

class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int low = 1;
        int high = 0;

        // Find maximum pile
        for (int pile : piles) {
            high = Math.max(high, pile);
        }

        int ans = high;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            long hours = 0;

            // Calculate total hours required at speed = mid
            for (int pile : piles) {
                hours += (long)Math.ceil((double)pile/mid);
            }

            // If Koko can finish within h hours,
            // try a smaller speed
            if (hours <= h) {
                ans = mid;      //minimum
                high = mid - 1;
            }

            // Otherwise increase the speed
            else {
                low = mid + 1;
            }
        }

        return ans;
    }
}