package class022归并分治;

// 翻转对数量
// 测试链接 : https://leetcode.cn/problems/reverse-pairs/

public class test2 {
    public static int MAX = 50001;

    public static int[] help = new int[MAX];

    public int reversePairs(int[] nums) {
        return counts(nums, 0, nums.length - 1);
    }

    public static int counts(int[] arr, int l, int r) {
        if (l == r)
            return 0;
        int mid = (l + r) / 2;
        return counts(arr, l, mid) + counts(arr, mid + 1, r) + merge(arr, l, mid, r);
    }

    public static int merge(int[] arr, int l, int m, int r) {
        int ans = 0;
        for (int i = l, j = m + 1; i <= m; i++) {
            while (j <= r &&(long) arr[i] > (long) arr[j] * 2) {
                j++;
            }
            ans += j - m - 1;
        }

        int i = l;
        int a = l;
        int b = m + 1;
        while (a <= m && b <= r) {
            help[i++] = arr[a] < arr[b] ? arr[a++] : arr[b++];
        }
        while (a <= m) {
            help[i++] = arr[a++];
        }
        while (b <= r) {
            help[i++] = arr[b++];
        }
        for (i = l; i <= r; i++) {
            arr[i] = help[i];
        }
        return ans;
    }
}
