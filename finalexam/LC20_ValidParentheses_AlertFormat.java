package finalexam;

import java.io.*;
import java.util.*;

// 題目 4
public class LC20_ValidParentheses_AlertFormat {

    
    public static boolean isValid(String s) {
        if (s == null || s.isEmpty()) return true;         
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

   
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        if (s == null) s = "";
        System.out.println(isValid(s));
    }
}

