class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;

        for(int weight : weights){
            low = Math.max(low, weight);
            high += weight;
        }

        while(low <= high){
            int mid = low + (high - low)/2;

            int daysUsed = 1;
            int currentWeight = 0;

            for(int weight : weights){

                if(currentWeight + weight > mid){
                    daysUsed++;
                    currentWeight = 0;
                }

                currentWeight += weight;
            }

            if(daysUsed <= days){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}