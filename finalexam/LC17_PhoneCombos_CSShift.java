package finalexam;

// 題目 8
import java.io.*;
import java.util.*;

public class LC17_PhoneCombos_CSShift {
    private static final String[] map = {
        "",    "",    "abc",  "def",
        "ghi", "jkl", "mno",  "pqrs",
        "tuv", "wxyz"
    };

    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.isEmpty()) return res;
        backtrack(new StringBuilder(), digits, 0, res);
        return res;
    }

    private static void backtrack(StringBuilder sb, String digits, int idx, List<String> res) {
        if (idx == digits.length()) {
            res.add(sb.toString());
            return;
        }
        String letters = map[digits.charAt(idx) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            sb.append(letters.charAt(i));
            backtrack(sb, digits, idx + 1, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String digits = br.readLine();
        List<String> ans = letterCombinations(digits == null ? "" : digits.trim());
        for (String s : ans) System.out.println(s);
    }
}

