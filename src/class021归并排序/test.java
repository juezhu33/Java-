package class021归并排序;

import java.util.Arrays;
import java.util.Random;


public class test {
    //merge归并排序
    public static void sortArray(int[] arr) {
        if (arr.length > 1)
            mergeSort(arr, 0, arr.length - 1);
    }

    public static int MAXN = 5001;

    public static int[] help = new int[MAXN];

    public static void mergeSort(int[] arr, int l, int r) {
        if (l == r)
            return;
        int m = l + (r - l) / 2;
        mergeSort(arr, l, m);
        mergeSort(arr, m + 1, r);
        merge(arr, l, m, r);
    }

    public static void merge(int[] arr, int l, int m, int r) {
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
    }


    public static void main(String[] args) {
        int testTime = 1000;  // 测试次数
        int maxSize = 100;    // 数组最大长度
        int maxValue = 1000;  // 数组元素最大值

        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = Arrays.copyOf(arr1, arr1.length);

            // 使用自定义的归并排序
            test.sortArray(arr1);
            // 使用系统自带的排序算法
            Arrays.sort(arr2);

            if (!Arrays.equals(arr1, arr2)) {
                succeed = false;
                System.out.println("Test failed!");
                System.out.println("Original: " + Arrays.toString(arr2));
                System.out.println("Custom:   " + Arrays.toString(arr1));
                break;
            }
        }

        System.out.println(succeed ? "All tests passed!" : "There are test failures.");
    }

    /**
     * 生成一个随机数组。
     *
     * @param maxSize  数组的最大长度（生成的数组长度将随机在 [0, maxSize] 之间）。
     * @param maxValue 数组中元素的最大值（每个元素的值将在 [-maxValue, maxValue] 之间）。
     * @return 一个随机生成的整数数组。
     */
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        Random random = new Random();

        // 随机生成数组长度，范围为 [0, maxSize]
        int size = random.nextInt(maxSize + 1);

        // 初始化数组
        int[] arr = new int[size];

        // 为数组中的每个元素赋值，值的范围为 [-maxValue, maxValue]
        for (int i = 0; i < size; i++) {
            // 生成两个 [0, maxValue] 之间的随机整数，相减以获得 [-maxValue, maxValue] 之间的值
            arr[i] = random.nextInt(maxValue + 1) - random.nextInt(maxValue + 1);
        }

        // 返回生成的随机数组
        return arr;
    }

}
