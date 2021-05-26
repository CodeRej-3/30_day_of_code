public class longestPalindromicSubstring {
    boolean[][] dp, checked;

    private boolean isPalindromic(String x, int lo, int hi) {
        if (checked[lo][hi])
            return dp[lo][hi];

        if (lo == hi) {
            dp[lo][hi] = true;
            checked[lo][hi] = true;
            return true;
        }

        if (x.charAt(lo) == x.charAt(hi) && lo + 1 == hi) {
            dp[lo][hi] = true;
            checked[lo][hi] = true;
            return true;
        }

        if (x.charAt(lo) == x.charAt(hi)) {
            if (!checked[lo + 1][hi - 1]) {
                isPalindromic(x, lo + 1, hi - 1);
            }
            if (dp[lo + 1][hi - 1]) {
                dp[lo][hi] = true;
                checked[lo][hi] = true;
                return true;
            }
        }

        dp[lo][hi] = false;
        checked[lo][hi] = true;
        return false;
    }

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len == 1)
            return s;
        String max = "";
        dp = new boolean[len][len];
        checked = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (isPalindromic(s, i, j))
                    if (max.length() < (j - i + 1))
                        max = s.substring(i, j + 1);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        longestPalindromicSubstring obj = new longestPalindromicSubstring();
        String res = obj.longestPalindrome("babad");
        System.out.println(res);
    }
}