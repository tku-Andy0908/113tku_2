package finalexam;
import java.util.*;

public class LC01_TwoSum_THSRHoliday {
    // 題目邏輯
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1}; // 找不到
    }

    // 測試用 main
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] ans = twoSum(nums, target);
        System.out.println("Result: [" + ans[0] + ", " + ans[1] + "]");
    }
}

/*
 * Time Complexity: O(n)
 * 說明：遍歷一次陣列，用 HashMap 查找補數。
 */
