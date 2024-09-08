package class006二分搜素;

//找>=n的最左边的数，如果没有则返回-1
import java.util.Arrays;

public class Code02_FindLeft {
    public static void main(String[] args) {
        int nMax = 100;
        int vMax = 10000;
        int testTime = 10000;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int n = (int) (Math.random() * nMax);
            int number = (int) (Math.random() * vMax);
            int[] arr = randomArray(n, vMax);
            Arrays.sort(arr);
            if (right(arr, number) != findLeft(arr, number))
                System.out.println("出现错误");
        }
        System.out.println("测试结束");
    }

    //随机生成数组
    public static int[] randomArray(int n, int v) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * v);
        }
        return arr;
    }

    //遍历搜索
    public static int right(int[] arr, int number) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= number)
                return i;
        }
        return -1;
    }

    //二分搜素
    public static int findLeft(int[] arr, int number) {
        int left = 0, right = arr.length - 1, mid = 0;
        int ans = -1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if(arr[mid] >= number)  {
                ans = mid;
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return ans;
    }

}
