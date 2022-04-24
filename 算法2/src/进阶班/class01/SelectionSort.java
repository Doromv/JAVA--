package 进阶班.class01;

import java.security.PublicKey;
import java.util.Arrays;

/**
 * @author Doromv
 * @create 2022-04-24-14:33
 */
public class SelectionSort {
    public static void selectionSort(int[] arr) {
        if(arr==null||arr.length<2){
            return;
        }
        for(int i=0;i<arr.length-1;i++){
            int minIndex=i;
            for (int j=i+1;j<arr.length;j++){
                minIndex=arr[j]<arr[minIndex]? j:minIndex;
            }
            tool.swap(arr,minIndex, i);
        }
    }
    //for test
    public static void comparator(int[] arr){
        Arrays.sort(arr);
    }
    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr=new int[(int)(Math.random()*(maxSize+1))];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=(int)(Math.random()*(maxValue+1))-(int)(Math.random()*maxValue);
        }
        return arr;
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
        for(int i=0;i<arr1.length;i++){
            if(arr1[i]!=arr2[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int testTime=10000;
        int maxSize=100;
        int maxValue=100;
        boolean succeed=true;
        for (int i=0;i<testTime;i++){
            int[] arr1=generateRandomArray(maxSize, maxValue);
            int[] arr2=tool.copyArray(arr1);
            comparator(arr2);
            selectionSort(arr1);
            if(!isEqual(arr1,arr2)){
                succeed=false;
                tool.printArray(arr2);
                tool.printArray(arr1);
                break;
            }
        }
        System.out.println(succeed);
    }
}
