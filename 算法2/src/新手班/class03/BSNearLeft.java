package 新手班.class03;

import java.util.Arrays;

/**
 * @author Doromv
 * @create 2022-04-09-15:59
 */
public class BSNearLeft {
    // arr有序的，返回大于等于num最左边的数
    public static int mostLeftNoLessNumIndex(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int l=0;
        int r=arr.length-1;
        int result=-1;
        while (l<=r){
            int mid=l+(r-l)/2;
            if(arr[mid]>=num){
                result=mid;
                r=mid-1;
            }else if(arr[mid]<num){
                l=mid+1;
            }
        }
        return result;
    }
    // test
    public static int test(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>=value){
                return i;
            }
        }
        return -1;
    }
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
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
            int value = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
            if (test(arr, value) != mostLeftNoLessNumIndex(arr, value)) {
                result = false;
                break;
            }
        }
        System.out.println(result);
    }
}
