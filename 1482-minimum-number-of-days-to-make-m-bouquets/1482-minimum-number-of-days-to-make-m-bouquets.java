// class Solution {
//     public int minDays(int[] bloomDay, int m, int k) {

            //TLE  - BRUTE FORCE


//         if ((long)m * k > bloomDay.length)
//             return -1;

//         int min = Integer.MAX_VALUE;
//         int max = Integer.MIN_VALUE;

//         for (int i = 0; i < bloomDay.length; i++) {
//             min = Math.min(min, bloomDay[i]);
//             max = Math.max(max, bloomDay[i]);
//         }

//         int arr[] = new int[bloomDay.length];
//         int c = 0;

//         for (int i = min; i <= max; i++) {

//             for (int j = 0; j < bloomDay.length; j++) {
//                 if (i == bloomDay[j]) {
//                     arr[j] = -1;
//                     c++;
//                 }
//             }

//             if (c < k) {
//                 continue;
//             }

//             int cons = 0;
//             int bouquets = 0;

//             for (int j = 0; j < arr.length; j++) {

//                 if (arr[j] == -1) {
//                     cons++;
//                 } else {
//                     bouquets += cons / k;
//                     cons = 0;
//                 }
//             }

//             bouquets += cons / k;

//             if (bouquets >= m)
//                 return i;
//         }

//         return -1;
//     }
// }
class Solution {

    public int minDays(int[] bloomDay, int m, int k) {

        if ((long)m * k > bloomDay.length)
            return -1;

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for (int day : bloomDay) {
            low = Math.min(low, day);
            high = Math.max(high, day);
        }

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canMake(bloomDay, mid, m, k)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private boolean canMake(int[] bloomDay, int day, int m, int k) {

        int bouquets = 0;
        int flowers = 0;

        for (int i = 0; i < bloomDay.length; i++) {

            if (bloomDay[i] <= day) {
                flowers++;
            } else {
                bouquets += flowers / k;
                flowers = 0;
            }
        }

        bouquets += flowers / k;

        return bouquets >= m;
    }
}