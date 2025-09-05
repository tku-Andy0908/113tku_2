package finalexam;
import java.io.*;
import java.util.*;

// 題目 1
public class LC01_TwoSum_THSRHoliday {

    
    public static int[] twoSum(int[] nums, int target) {
       
        Map<Integer, Integer> need = new HashMap<>(nums.length * 2);
        for (int i = 0; i < nums.length; i++) {
            Integer j = need.get(nums[i]); // 
            if (j != null) return new int[]{j, i};
            need.put(target - nums[i], i);
        }
        return new int[]{-1, -1};
    }

    
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        int n = fs.nextInt();
        int target = fs.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = fs.nextInt();

        int[] ans = twoSum(a, target);
        System.out.println(ans[0] + " " + ans[1]);
    }

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



