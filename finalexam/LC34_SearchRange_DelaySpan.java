package finalexam;

// 題目 19
import java.io.*;
import java.util.*;

public class LC34_SearchRange_DelaySpan {
    private static int lowerBound(int[] a, int x) {
        int l = 0, r = a.length;
        while (l < r) {
            int m = (l + r) >>> 1;
            if (a[m] >= x) r = m;
            else l = m + 1;
        }
        return l;
    }

    public static int[] searchRange(int[] a, int target) {
        if (a.length == 0) return new int[]{-1, -1};
        int L = lowerBound(a, target);
        if (L == a.length || a[L] != target) return new int[]{-1, -1};
        int R = lowerBound(a, target + 1) - 1;
        return new int[]{L, R};
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String first = br.readLine();
        if (first == null || first.trim().isEmpty()) { System.out.println("-1 -1"); return; }
        StringTokenizer st = new StringTokenizer(first);
        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int[] a = new int[n];
        if (n > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());
        }
        int[] ans = searchRange(a, target);
        System.out.println(ans[0] + " " + ans[1]);
    }
}

