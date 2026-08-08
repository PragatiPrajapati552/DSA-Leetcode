class Solution {
    public int maxScore(int[] cardPoints, int k) {

        int n = cardPoints.length;

        int totalSum = 0;

        for (int i = 0; i < n; i++) {
            totalSum += cardPoints[i];
        }

        // If k == n, we have to take all cards
        if (k == n) {
            return totalSum;
        }

        int windowSize = n - k;

        // Sum of first window
        int windowSum = 0;

        for (int i = 0; i < windowSize; i++) {
            windowSum += cardPoints[i];
        }

        int minWindowSum = windowSum;

        // Slide the window
        int left = 0;

        for (int right = windowSize; right < n; right++) {

            windowSum += cardPoints[right];
            windowSum -= cardPoints[left];

            left++;

            minWindowSum = Math.min(minWindowSum, windowSum);
        }

        return totalSum - minWindowSum;
    }
}