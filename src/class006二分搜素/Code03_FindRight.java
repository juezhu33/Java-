package class006二分搜素;


import java.util.Arrays;// 有序数组中找<=num的最右位置

public class Code03_FindRight {
    public static void main(String[] args) {
        int nMax = 100;
        int vMax = 10000;
        int testTime = 1000;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int n = (int) (Math.random() * nMax);
            int number = (int) (Math.random() * vMax);
            int[] arr = randomArray(n, vMax);
            Arrays.sort(arr);
            if (right(arr, number) != findRight(arr, number))
                System.out.println("出现错误");
        }
        System.out.println("测试结束");
    }

    public static int[] randomArray(int n, int v) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * v) + 1;
        }
        return arr;
    }

    public static int right(int[] arr, int num) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] <= num) {
                return i;
            }
        }
        return -1;
    }

    public static int findRight(int[] arr, int number) {
        int left = 0, right = arr.length - 1, mid;
        int ans = -1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (arr[mid] <= number) {
                left = mid + 1;
                ans = mid;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }


}
