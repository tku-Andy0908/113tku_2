class Solution {
    public int reverse(int x) {
        long rev = 0; // 用 long 暫存，避免中途溢出
        while (x != 0) {
            rev = rev * 10 + x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE) {
                return 0; // 超出範圍直接回傳 0
            }
        }
        return (int) rev;
    }
}
