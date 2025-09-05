package finalexam;

// 題目 17
import java.io.*;

public class LC28_StrStr_NoticeSearch {
    public static int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        int n = haystack.length(), m = needle.length();
        if (m > n) return -1;
        for (int i = 0; i <= n - m; i++) {
            int j = 0;
            while (j < m && haystack.charAt(i + j) == needle.charAt(j)) j++;
            if (j == m) return i;
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String haystack = br.readLine();
        String needle = br.readLine();
        if (haystack == null) haystack = "";
        if (needle == null) needle = "";
        System.out.println(strStr(haystack, needle));
    }
}

