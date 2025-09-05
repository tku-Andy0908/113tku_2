class Solution {
    public int myAtoi(String s) {
        int i = 0, n = s.length();
        // 1. 跳過前導空格
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // 2. 判斷正負號
        int sign = 1;
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        // 3. 讀取數字
        long num = 0; // 用 long 暫存，避免溢出
        while (i < n && Character.isDigit(s.charAt(i))) {
            num = num * 10 + (s.charAt(i) - '0');
            if (sign * num > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (sign * num < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            i++;
        }

        return (int) (sign * num);
    }
}

