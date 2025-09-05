package finalexam;

import java.io.*;
import java.util.*;

/** 題目 4：緊急通報格式括號檢查 */
public class LC20_ValidParentheses_AlertFormat {

    // 判斷括號字串是否有效
    public static boolean isValid(String s) {
        if (s == null || s.isEmpty()) return true;          // 空字串視為合法
        Deque<Character> st = new ArrayDeque<>();
        Map<Character, Character> pair = Map.of(
            ')', '(', ']', '[', '}', '{'
        );

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                st.push(c);
            } else { // c 是閉括號
                Character need = pair.get(c);
                if (need == null || st.isEmpty() || st.peek() != need) return false;
                st.pop();
            }
        }
        return st.isEmpty();
    }

    // Input: 一行括號字串；Output: true/false
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        if (s == null) s = "";
        System.out.println(isValid(s));
    }
}

/*
 * Time Complexity: O(n)
 * 說明：單趟掃描，每個字元最多一次入/出棧；空間 O(n) 於最壞全開括號情況。
 */
