package finalexam;

import java.io.*;
import java.util.Arrays;

// 題目 2
public class LC03_NoRepeat_TaipeiMetroTap {

   
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) return 0;
        int[] last = new int[256];          
        Arrays.fill(last, -1);

        int left = 0, ans = 0;
        for (int r = 0; r < s.length(); r++) {
            int c = s.charAt(r);
            if (last[c] >= left) left = last[c] + 1; 
            last[c] = r;
            int len = r - left + 1;
            if (len > ans) ans = len;
        }
        return ans;
    }

   
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();               
        if (s == null) { System.out.println(0); return; }
        System.out.println(lengthOfLongestSubstring(s));
    }
}




