class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int windowSize = n-k;

        int windowSum = 0;

        for(int i = 0; i<windowSize; i++){
            windowSum += cardPoints[i];
        }

        int minwindowSum = windowSum;

        for(int i = windowSize; i<n; i++){
            windowSum = windowSum - cardPoints[i - windowSize] + cardPoints[i];
            minwindowSum = Math.min(windowSum, minwindowSum);
        }

        int totalSum = 0;

        for(int i = 0; i<n; i++){
            totalSum += cardPoints[i];
        }

        return totalSum - minwindowSum;
    }

}