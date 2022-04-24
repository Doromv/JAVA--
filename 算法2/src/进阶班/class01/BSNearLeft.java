package 进阶班.class01;

import java.util.Arrays;

/**
 * @author Doromv
 * @create 2022-04-24-16:04
 */
public class BSNearLeft {
    // 在arr上，找满足>=value的最左位置
    public static int nearestIndex(int[] arr, int value) {
        int l=0;
        int r=arr.length-1;
        int index=-1;
        while (l<=r){
            int m=l+((r-l)>>1);
            if(arr[m]>=value){
                index=m;
                r=m-1;
            }else {
                l=m+1;
            }
        }
        return index;
    }
    // for test
    public static int test(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= value) {
                return i;
            }
        }
        return -1;
    }
    // for test
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
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            Arrays.sort(arr);
            int value = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
            if (test(arr, value) != nearestIndex(arr, value)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed);
    }
}
