package finalexam;

// 題目 16
import java.io.*;
import java.util.*;

public class LC27_RemoveElement_Recycle {
    public static int removeElement(int[] nums, int val) {
        int write = 0;
        for (int x : nums) {
            if (x != val) nums[write++] = x;
        }
        return write;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String first = br.readLine();
        if (first == null || first.trim().isEmpty()) {
            System.out.println(0);
            return;
        }
        StringTokenizer st = new StringTokenizer(first);
        int n = Integer.parseInt(st.nextToken());
        int val = Integer.parseInt(st.nextToken());
        int[] nums = new int[n];
        if (n > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) nums[i] = Integer.parseInt(st.nextToken());
        }
        int len = removeElement(nums, val);
        System.out.println(len);
        if (len > 0) {
            for (int i = 0; i < len; i++) {
                System.out.print(nums[i]);
                if (i < len - 1) System.out.print(" ");
            }
            System.out.println();
        }
    }
}
