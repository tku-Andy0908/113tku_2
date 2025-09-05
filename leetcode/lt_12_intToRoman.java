// 題目：Integer to Roman
// 給定一個整數，將它轉換成羅馬數字 (1 <= num <= 3999)。
class Solution {
    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {
            "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"
        };

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length && num > 0; i++) {
            while (num >= values[i]) {
                num -= values[i];
                sb.append(symbols[i]);
            }
        }
        return sb.toString();
    }
}
/*
解題思路：
1. 羅馬數字採用貪心演算法，從最大值 (1000=M) 開始處理，逐步減去對應的數字。
2. 當前數字大於等於 values[i] 時，就把對應的 symbols[i] 加到結果，並且 num 減去 values[i]。
3. 包含「特殊表示法」例如 900=CM, 400=CD, 90=XC, 40=XL, 9=IX, 4=IV，提前放進陣列處理。
4. 最終得到正確的羅馬數字。
時間複雜度：O(1)，因為最大數字固定 (3999)，迴圈次數有限。
空間複雜度：O(1)。
*/

