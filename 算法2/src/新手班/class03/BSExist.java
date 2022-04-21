package 新手班.class03;

import java.util.Arrays;

/**
 * @author Doromv
 * @create 2022-04-09-15:36
 */
public class BSExist {
    // arr保证有序
    public static boolean find(int[] arr, int num) {
        if(arr==null||arr.length==0){
            return false;
        }
        int l=0;
        int r=arr.length-1;
        while (l<=r){
            int mid=l+(r-l)/2;
            if(arr[mid]==num){
                return true;
            }else if(arr[mid]>num){
                r=mid-1;
            }else {
                l=mid+1;
            }
        }
        return false;
    }
    // for test
    public static boolean test(int[] sortedArr, int num) {
        for (int i : sortedArr) {
            if (i == num) {
                return true;
            }
        }
        return false;
    }
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr=new int[(int) (Math.random()*(maxSize+1))];
        for (int i=0;i<arr.length;i++){
            arr[i]= (int) (Math.random()*(maxValue+1))-(int) (Math.random()*(maxValue));
        }
        return arr;
    }
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 10;
        int maxValue = 100;
        boolean result = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            Arrays.sort(arr);
            int num = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
            if (test(arr, num) != find(arr, num)) {
                result = false;
                break;
            }
        }
        System.out.println(result);
    }
}
