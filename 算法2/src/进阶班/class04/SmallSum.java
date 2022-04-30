package 进阶班.class04;

/**
 * @author Doromv
 * @create 2022-04-30-15:53
 */
public class SmallSum {
    public static int smallSum(int[] arr) {
        if(arr==null||arr.length<2){
            return 0;
        }
        return process(arr,0, arr.length-1);
    }
    public static int process(int[] arr, int l, int r) {
        if(l==r){
            return 0;
        }
        int m = l + ((r - l) >> 1);
        return process(arr,l, m)+process(arr,m+1, r)+merge(arr,l,m,r);
    }

    private static int merge(int[] arr, int l, int m, int r) {
        int indexL=l;
        int indexR=m+1;
        int index=0;
        int sum=0;
        int[] help=new int[r-l+1];
        while (indexL<=m&&indexR<=r) {
            sum+=arr[indexL]<arr[indexR]? (r-indexR+1)*arr[indexL]:0;
            help[index++]=arr[indexL]<arr[indexR]?arr[indexL++]:arr[indexR++];
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
        return sum;
    }

    // for test
    public static int comparator(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int res = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                res += arr[j] < arr[i] ? arr[j] : 0;
            }
        }
        return res;
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
        boolean falg = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            if (smallSum(arr1) != comparator(arr2)) {
                falg = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(falg);
    }
}
