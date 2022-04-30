package 进阶班.class04;

import com.sun.xml.internal.bind.v2.model.core.ID;

/**
 * @author Doromv
 * @create 2022-04-30-16:34
 */
public class ReversePair {
    public static int reverPairNumber(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return process(arr, 0, arr.length - 1);
    }
    public static int process(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int m = l + ((r - l) >> 1);
        return process(arr,l, m)+process(arr,m+1, r)+merge(arr,l,m,r);
    }
    public static int merge(int[] arr, int l, int m, int r) {
        int[] help = new int[r-l+1];
        int index = help.length - 1;
        int indexL=m;
        int indexR=r;
        int sum = 0;
        while (indexL>=l&&indexR>=m+1){
            sum+=arr[indexR]<arr[indexL]? (indexR-m):0;
            help[index--]=arr[indexL]>arr[indexR]? arr[indexL--]:arr[indexR--];
        }
        while (indexL>=l){
            help[index--]=arr[indexL--];
        }
        while (indexR>=m+1){
            help[index--]=arr[indexR--];
        }
        for (int i = 0; i < help.length; i++) {
            arr[l+i]=help[i];
        }
        return sum;
    }
    // for test
    public static int comparator(int[] arr) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    ans++;
                }
            }
        }
        return ans;
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
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
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
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
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean flag=true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            if (reverPairNumber(arr1) != comparator(arr2)) {
               flag=false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(flag);
    }
}
