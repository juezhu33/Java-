package class006二分搜素;

import java.util.Arrays;

public class Code01_FindNumber {
    public static void main(String[] args) {
        int nMax = 100;         //限制数组最大长度
        int vMax = 100000;       //限制数组最大的元素
        int testTime = 5000;    //测试多少个数组
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            //随机生成数组长度，验证不同长度的数组
            int n = (int) (Math.random() * nMax);
            //随机生成数组
            int[] arr = randomArray(n, vMax);
            //排序，二分搜索的前提
            Arrays.sort(arr);
            //随机选择要找的数
            int number = (int) (Math.random() * vMax);
            //比较两个数组，此处返回值为boolean
            if (findNumber(arr, number) != findNumber2(arr, number))
                System.out.println("测试出错");
        }
        System.out.println("测试结束");
    }


    //随机生成数组
    public static int[] randomArray(int n, int v) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            // Math.random() -> double -> [0,1)范围山的一个小数，0.37463473126、0.001231231，等概率！
            // Math.random() * v -> double -> [0,v)一个小数，依然等概率
            // (int)(Math.random() * v) -> int -> 0 1 2 3 ... v-1，等概率的！
            // (int) (Math.random() * v) + 1 -> int -> 1 2 3 .... v，等概率的！
            arr[i] = (int) (Math.random() * v) + 1;
        }
        return arr;
    }

    //遍历数组查找
    public static boolean findNumber(int[] arr, int num) {
        for (int cur : arr) {
            if (cur == num)
                return true;
        }
        return false;
    }

    //二分搜索
    public static boolean findNumber2(int[] arr, int num) {
        if (arr == null || arr.length == 0)
            return false;
        int left = 0, right = arr.length - 1, mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (arr[mid] == num)
                return true;
            else if (arr[mid] > num)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return false;
    }

}



