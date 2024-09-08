package class006二分搜素;

public class Code04_FindPeakElement {
    public static int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1; // 如果数组为空，返回-1
        if (nums.length == 1)
            return 0; // 如果数组只有一个元素，返回0
        if (nums[0] > nums[1])
            return 0; // 如果第一个元素大于第二个元素，返回0
        if (nums[nums.length - 1] > nums[nums.length - 2])
            return nums.length - 1; // 如果最后一个元素大于倒数第二个元素，返回数组长度减1

        int left = 1, right = nums.length - 2, mid;

        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1; // 如果中间元素小于右边元素，说明峰值在右侧
            } else if (nums[mid] < nums[mid - 1]) {
                right = mid - 1; // 如果中间元素小于左边元素，说明峰值在左侧
            } else {
                return mid; // 找到一个峰值
            }
        }

        return -1; // 理论上不应该到达这里
    }
}
