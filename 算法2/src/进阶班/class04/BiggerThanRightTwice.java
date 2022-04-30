package 进阶班.class04;

/**
 * @author Doromv
 * @create 2022-04-30-17:21
 */
//  本题测试链接 : https://leetcode.com/problems/reverse-pairs/
public class BiggerThanRightTwice {
    public static int reversePairs(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return process(arr,0,arr.length-1);
    }
    public static int process(int[] arr, int l, int r) {
        if(l==r){
            return 0;
        }
        int m=l+((r-l)>>1);
        return process(arr,l,m)+process(arr,m+1, r)+merge(arr,l,m,r);
    }
    public static int merge(int[] arr, int l, int m,int r) {
        int windowR=m+1;
        int ans=0;
        for (int i = l; i <=m ; i++) {
           while ( windowR <=r&&(long)arr[i]>(long)arr[windowR]*2) {
                windowR++;
            }
           ans+=windowR-m-1;
        }
        int[] help=new int[r-l+1];
        int index=0;
        int indexL=l;
        int indexR=m+1;
        while (indexL<=m&&indexR<=r){
            help[index++]=arr[indexL]<=arr[indexR]? arr[indexL++]:arr[indexR++];
        }
        while (indexL<=m){
            help[index++]=arr[indexL++];
        }
        while (indexR<=r){
            help[index++]=arr[indexR++];
        }
        for (int i = 0; i < help.length; i++) {
            arr[l+i]=help[i];
        }
        return ans;
    }
    // for test
    public static int comparator(int[] arr) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > (arr[j] << 1)) {
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
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) ((maxValue + 1) * Math.random());
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
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            if (reversePairs(arr1) != comparator(arr2)) {
                System.out.println("Oops!");
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println("测试结束");
    }

}
