package finalexam;

// 題目 15
import java.io.*;
import java.util.*;

public class LC26_RemoveDuplicates_Scores {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int write = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[write - 1]) {
                nums[write] = nums[i];
                write++;
            }
        }
        return write;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) {
            System.out.println(0);
            return;
        }
        int n = Integer.parseInt(line.trim());
        int[] nums = new int[n];
        if (n > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) nums[i] = Integer.parseInt(st.nextToken());
        }
        int len = removeDuplicates(nums);
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

