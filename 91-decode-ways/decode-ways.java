class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int prev2 = 1;
        int prev1 = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 1; i < n; i++) {
            int curr = 0;

            if (s.charAt(i) != '0') {
                curr += prev1;
            }

            int twoDigit = (s.charAt(i - 1) - '0') * 10 + (s.charAt(i) - '0');

            if (twoDigit >= 10 && twoDigit <= 26) {
                curr += prev2;
            }

            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}