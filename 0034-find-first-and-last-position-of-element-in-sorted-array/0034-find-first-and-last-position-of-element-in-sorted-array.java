class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = first(nums, target);
        int last = last(nums, target);
        return new int[]{first, last};
    }

    private int first(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        int ans = -1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                ans = mid;
                high = mid - 1;
            } else if (target < nums[mid]){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private int last(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        int ans = -1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                ans = mid;
                low = mid + 1;
            } else if (target < nums[mid]){
                
                high = mid - 1;
            } else {
                low  = mid + 1;
            }
        }

        return ans;
    }
    
}