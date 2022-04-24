package 进阶班.class01;

import java.util.Arrays;
import java.util.Date;

/**
 * @author Doromv
 * @create 2022-04-24-15:00
 */
public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        if(arr.length<2||arr==null){
            return;
        }
        for (int i=arr.length-1;i>=0;i--){
            for (int j = 0; j < i; j++) {
                if(arr[j]>arr[j+1]){
                    tool.swap(arr,j, j+1);
                }
            }
        }
    }
    // for test
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }
    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr=new int[(int) (Math.random()*(maxSize+1))];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=(int) (Math.random()*(maxValue+1))-(int) (Math.random()*maxValue);
        }
        return arr;
    }
    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if(arr1==null^arr2==null){
            return false;
        }
        if(arr1==null&&arr2==null){
            return true;
        }
        if(arr1.length!= arr2.length){
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if(arr1[i]!=arr2[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int testTime=10000;
        int maxValue=1000;
        int maxSize=1000;
        boolean succeed=true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = tool.copyArray(arr1);
            bubbleSort(arr1);
            comparator(arr2);
            if(!isEqual(arr1,arr2)){
                succeed=false;
                break;
            }
        }
        System.out.println(succeed);
    }
}
