package finalexam;

import java.io.*;
import java.util.*;

// 題目 3
public class LC04_Median_QuakeFeeds {

 
    public static double findMedianSortedArrays(double[] A, double[] B) {
        
        if (A.length > B.length) return findMedianSortedArrays(B, A);
        int n = A.length, m = B.length;
        int half = (n + m + 1) / 2;

        int lo = 0, hi = n;
        while (lo <= hi) {
            int i = (lo + hi) >>> 1;    
            int j = half - i;            

            double Aleft  = (i == 0) ? Double.NEGATIVE_INFINITY : A[i - 1];
            double Aright = (i == n) ? Double.POSITIVE_INFINITY : A[i];
            double Bleft  = (j == 0) ? Double.NEGATIVE_INFINITY : B[j - 1];
            double Bright = (j == m) ? Double.POSITIVE_INFINITY : B[j];

            if (Aleft <= Bright && Bleft <= Aright) {
                
                if (((n + m) & 1) == 0) {
                    double leftMax = Math.max(Aleft, Bleft);
                    double rightMin = Math.min(Aright, Bright);
                    return (leftMax + rightMin) / 2.0;
                } else {
                    return Math.max(Aleft, Bleft);
                }
            } else if (Aleft > Bright) {
                hi = i - 1;              
            } else {
                lo = i + 1;             
            }
        }
       
        throw new IllegalArgumentException("Invalid input.");
    }

  
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



