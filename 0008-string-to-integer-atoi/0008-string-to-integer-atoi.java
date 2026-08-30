class Solution {
    public int myAtoi(String s) {
        int i = 0;

        //spaces
        while(i < s.length() && s.charAt(i) == ' '){
            i++;
        }

        //handle sign
        int sign = 1;

        if(i < s.length() && s.charAt(i) == '-'){
            sign = -1;
            i++;
        }
        else if(i < s.length() && s.charAt(i) == '+'){
            i++;
        }

        //read digits
        int ans = 0;

        while(i < s.length() && Character.isDigit(s.charAt(i))){
            int digit = s.charAt(i) - '0';

            //overflow
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && digit > 7)) {

                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            ans = ans * 10 + digit;

            i++;
        }

        

        return ans*sign;

    }
}