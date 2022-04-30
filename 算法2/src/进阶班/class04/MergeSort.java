package 进阶班.class04;

/**
 * @author Doromv
 * @create 2022-04-30-14:57
 */
public class MergeSort {
    public static void mergeSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    public static void process(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int m = l + ((r - l) >> 1);
        process(arr, l, m);
        process(arr, m + 1, r);
        merge(arr, l, m, r);
    }

    private static void merge(int[] arr, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int indexL = l;
        int indexR = m + 1;
        int index = 0;
        while (indexL <= m && indexR <= r) {
            help[index++] = arr[indexL] <= arr[indexR] ? arr[indexL++] : arr[indexR++];
        }
        while (indexL <= m) {
            help[index++] = arr[indexL++];
        }
        while (indexR <= r) {
            help[index++] = arr[indexR++];
        }
        for (int i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
    }

    public static void mergeSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int n = arr.length;
        int mergeSize = 1;
        while (mergeSize < n) {
            int l = 0;
            while (l < n) {
                int m = l + mergeSize - 1;
                if (m > n) {
                    break;
                }
                int r = Math.min(m + mergeSize, n - 1);
                merge(arr, l, m, r);
                l = r + 1;
            }
            if (mergeSize > n / 2) {
                break;
            }
            mergeSize = mergeSize << 1;
        }
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) (Math.random() * (maxSize + 1))];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (maxValue + 1)) - (int) (Math.random() * (maxValue));
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if (arr1 == null ^ arr2 == null) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean flag = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            mergeSort1(arr1);
            mergeSort2(arr2);
            if (!isEqual(arr1, arr2)) {
                flag = false;
            }
        }
        System.out.println(flag);
    }
}
