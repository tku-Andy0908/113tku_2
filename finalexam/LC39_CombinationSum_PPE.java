package finalexam;

// 題目 20（I）
import java.io.*;
import java.util.*;

public class LC39_CombinationSum_PPE {
    public static List<List<Integer>> combinationSum(int[] cand, int target) {
        Arrays.sort(cand);
        List<List<Integer>> res = new ArrayList<>();
        dfs(cand, 0, target, new ArrayList<>(), res);
        return res;
        }
    private static void dfs(int[] c, int i, int rem, List<Integer> path, List<List<Integer>> res) {
        if (rem == 0) { res.add(new ArrayList<>(path)); return; }
        if (i == c.length || rem < 0) return;
        // 選 c[i]
        path.add(c[i]);
        dfs(c, i, rem - c[i], path, res); // 可重複使用
        path.remove(path.size() - 1);
        // 不選 c[i]
        dfs(c, i + 1, rem, path, res);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int[] a = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());
        List<List<Integer>> ans = combinationSum(a, target);
        for (List<Integer> comb : ans) {
            for (int i = 0; i < comb.size(); i++) {
                if (i > 0) System.out.print(" ");
                System.out.print(comb.get(i));
            }
            System.out.println();
        }
    }
}
