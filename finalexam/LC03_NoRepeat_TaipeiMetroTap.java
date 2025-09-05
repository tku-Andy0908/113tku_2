package finalexam;

import java.io.*;
import java.util.Arrays;

/** 題目 2：北捷刷卡最長無重複片段 */
public class LC03_NoRepeat_TaipeiMetroTap {

    // 滑動視窗：回傳最長長度
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) return 0;
        int[] last = new int[256];          // 假設 ASCII 可見字元
        Arrays.fill(last, -1);

        int left = 0, ans = 0;
        for (int r = 0; r < s.length(); r++) {
            int c = s.charAt(r);
            if (last[c] >= left) left = last[c] + 1; // 縮左界
            last[c] = r;
            int len = r - left + 1;
            if (len > ans) ans = len;
        }
        return ans;
    }

    // 依題目指定：一行輸入字串，輸出最長長度
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();               // 可能為空行或 null
        if (s == null) { System.out.println(0); return; }
        System.out.println(lengthOfLongestSubstring(s));
    }
}

/*
 * Time Complexity: O(n)
 * 說明：右指針每步前進一次，左指針僅單調右移；每字元最多進出視窗一次。
 */

