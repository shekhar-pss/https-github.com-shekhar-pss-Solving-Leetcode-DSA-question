class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            int[] odd = expand(s, i, i);
            if (odd[1] - odd[0] > end - start) {
                start = odd[0];
                end = odd[1];
            }

            int[] even = expand(s, i, i + 1);
            if (even[1] - even[0] > end - start) {
                start = even[0];
                end = even[1];
            }
        }

        return s.substring(start, end + 1);
    }

    private int[] expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // overshot by one on each side after the loop
        return new int[] { left + 1, right - 1 };
    }
}