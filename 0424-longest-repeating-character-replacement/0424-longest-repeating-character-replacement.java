class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int[] count = new int[26];
        int maxFrequency = 0;
        int maxLength = 0;

        for(int right = 0; right < s.length(); right++){

            int index = s.charAt(right) - 'A';
            count[index]++;
            maxFrequency = Math.max(count[index], maxFrequency);

            while(((right-left+1) - maxFrequency ) > k){

                int leftIndex = s.charAt(left) - 'A';
                count[leftIndex]--;
                left++;

            }

            int currLength = right-left+1;
            maxLength = Math.max(currLength, maxLength);
        }

        return maxLength;
    }
}