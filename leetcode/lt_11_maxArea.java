// 題目：Container With Most Water
// 給定一個整數陣列 height，找出能裝最多水的容器面積。
class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0;

        while (left < right) {
            int h = Math.min(height[left], height[right]);
            int width = right - left;
            max = Math.max(max, h * width);

            // 移動較短的那一邊，嘗試找更高的邊
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }
}
/*
解題思路：
1. 初始設置左右指針，分別在陣列的開頭與結尾。
2. 計算當前容器的面積 = min(height[left], height[right]) * (right - left)。
3. 更新最大值，然後移動較短的一邊，因為只有這樣才可能找到更大的容器。
4. 迴圈直到左右指針相遇。
時間複雜度：O(n)，只需一次遍歷。
空間複雜度：O(1)。
*/
