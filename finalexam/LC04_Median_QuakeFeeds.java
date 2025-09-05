package finalexam;

import java.io.*;
import java.util.*;

/** 題目 3：地震速報雙資料源中位數 */
public class LC04_Median_QuakeFeeds {

    // 回傳兩個已排序數列聯合集的中位數（不真正合併）
    public static double findMedianSortedArrays(double[] A, double[] B) {
        // 確保 A 是較短的陣列
        if (A.length > B.length) return findMedianSortedArrays(B, A);
        int n = A.length, m = B.length;
        int half = (n + m + 1) / 2;

        int lo = 0, hi = n;
        while (lo <= hi) {
            int i = (lo + hi) >>> 1;     // A 的切割
            int j = half - i;            // B 的切割

            double Aleft  = (i == 0) ? Double.NEGATIVE_INFINITY : A[i - 1];
            double Aright = (i == n) ? Double.POSITIVE_INFINITY : A[i];
            double Bleft  = (j == 0) ? Double.NEGATIVE_INFINITY : B[j - 1];
            double Bright = (j == m) ? Double.POSITIVE_INFINITY : B[j];

            if (Aleft <= Bright && Bleft <= Aright) {
                // 命中正確切割
                if (((n + m) & 1) == 0) {
                    double leftMax = Math.max(Aleft, Bleft);
                    double rightMin = Math.min(Aright, Bright);
                    return (leftMax + rightMin) / 2.0;
                } else {
                    return Math.max(Aleft, Bleft);
                }
            } else if (Aleft > Bright) {
                hi = i - 1;              // A 的左邊太大，往左縮
            } else {
                lo = i + 1;              // A 的右邊太小，往右擴
            }
        }
        // 理論上不會到這裡（輸入已排序且 n+m>=1）
        throw new IllegalArgumentException("Invalid input.");
    }

    // I/O：第一行 n m；第二行 n 個浮點數；第三行 m 個浮點數；輸出保留 1 位
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        Integer nObj = fs.nextIntOrNull();
        if (nObj == null) { System.out.println("0.0"); return; }
        int n = nObj, m = fs.nextInt();

        double[] A = new double[n];
        for (int i = 0; i < n; i++) A[i] = fs.nextDouble();
        double[] B = new double[m];
        for (int i = 0; i < m; i++) B[i] = fs.nextDouble();

        double ans = findMedianSortedArrays(A, B);
        System.out.printf(java.util.Locale.US, "%.1f%n", ans);
    }

    /** 簡單快取的輸入工具（支援空行） */
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;
        FastScanner(InputStream is) { br = new BufferedReader(new InputStreamReader(is)); }
        String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                String line = br.readLine();
                if (line == null) return null;
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }
        Integer nextIntOrNull() throws IOException { String s = next(); return s == null ? null : Integer.parseInt(s); }
        int nextInt() throws IOException { return Integer.parseInt(next()); }
        double nextDouble() throws IOException { return Double.parseDouble(next()); }
    }
}

/*
 * Time Complexity: O(log(min(n, m)))
 * 說明：在較短陣列上做二分搜尋，每次檢查切割是否合法；空間 O(1)。
 */

