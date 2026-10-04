class Solution {
    public int numberOfSubstrings(String s) {
        int left = 0;
        int answer = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        for(int right = 0; right < s.length(); right++){

            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            while(map.getOrDefault('a', 0) > 0 && 
                  map.getOrDefault('b', 0) > 0 && 
                  map.getOrDefault('c', 0) > 0){

                char leftChar = s.charAt(left);
                
                map.put(leftChar, map.getOrDefault(leftChar, 0) - 1);

                left++;

            }

            answer += left;

        }

        return answer;
    }
}