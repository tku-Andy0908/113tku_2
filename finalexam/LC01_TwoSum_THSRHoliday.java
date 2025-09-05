package finalexam;
import java.io.*;
import java.util.*;

/** 題目 1：高鐵連假加班車 Two Sum */
public class LC01_TwoSum_THSRHoliday {

    // 回傳兩個索引；找不到回傳 {-1, -1}
    public static int[] twoSum(int[] nums, int target) {
        // key: 需要的數 (target - nums[i])  -> value: 索引 i
        Map<Integer, Integer> need = new HashMap<>(nums.length * 2);
        for (int i = 0; i < nums.length; i++) {
            Integer j = need.get(nums[i]); // 目前數字是否剛好是前面「需要的數」
            if (j != null) return new int[]{j, i};
            need.put(target - nums[i], i);
        }
        return new int[]{-1, -1};
    }

    // 依題目指定的 I/O：第一行 n target；第二行 n 個整數
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        int n = fs.nextInt();
        int target = fs.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = fs.nextInt();

        int[] ans = twoSum(a, target);
        System.out.println(ans[0] + " " + ans[1]);
    }

    /** 簡單快速讀取器（比 Scanner 穩定、快） */
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;
        FastScanner(InputStream is) { br = new BufferedReader(new InputStreamReader(is)); }
        String next() throws IOException {
            while (st == null || !st.hasMoreElements()) {
                String line = br.readLine();
                if (line == null) return null;
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }
        int nextInt() throws IOException { return Integer.parseInt(next()); }
    }
}

/*
 * Time Complexity: O(n)
 * 說明：一次遍歷陣列，對每個元素使用 HashMap O(1) 查找與記錄所需補數；最壞為線性。
 */

