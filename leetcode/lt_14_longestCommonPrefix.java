// 題目：Longest Common Prefix
// 給定一組字串，找出它們的最長公共前綴 (Longest Common Prefix)。
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        String prefix = strs[0]; // 先假設第一個字串是 prefix
        for (int i = 1; i < strs.length; i++) {
            // 一直縮短 prefix，直到當前字串以它為開頭
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
}
/*
解題思路：
1. 假設第一個字串是公共前綴 prefix。
2. 逐一與後續字串比較：
   - 如果當前字串不以 prefix 開頭，縮短 prefix（去掉最後一個字元）。
   - 持續檢查，直到符合條件或 prefix 變空字串。
3. 最後剩下的 prefix 就是最長公共前綴。
時間複雜度：O(n * m)，n = 字串數量，m = 最長字串長度。
空間複雜度：O(1)。
*/
