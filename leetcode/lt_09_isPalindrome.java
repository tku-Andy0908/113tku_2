class Solution {
    public boolean isPalindrome(int x) {
        // 負數一定不是回文
        if (x < 0) return false;

        int original = x;
        long reversed = 0;

        while (x != 0) {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }

        return original == reversed;
    }
}

