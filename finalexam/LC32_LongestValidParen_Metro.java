package finalexam;

// 題目 5
import java.io.*;
import java.util.*;

public class LC32_LongestValidParen_Metro {
    public static int longestValidParentheses(String s) {
        int ans = 0;
        Deque<Integer> st = new ArrayDeque<>();
        st.push(-1);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                st.push(i);
            } else {
                st.pop();
                if (st.isEmpty()) {
                    st.push(i);
                } else {
                    ans = Math.max(ans, i - st.peek());
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println(longestValidParentheses(s == null ? "" : s));
    }
}
