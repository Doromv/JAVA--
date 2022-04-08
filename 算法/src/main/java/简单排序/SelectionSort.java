package 简单排序;

import Unity.swap;

/**
 * @author Doromv
 * @create 2022-03-22-8:39
 */
public class SelectionSort {
    public static void slectionSort(int[] arr) {
        if(arr.length<2||arr==null) {
            return;
        }
        for(int i=0;i<arr.length-1;i++){
            int minIndex=i;
            for(int j=i+1;j<arr.length-1;j++){
               minIndex=arr[j]<arr[minIndex]? j:minIndex;
            }
          swap.swap(arr,i,minIndex);
        }
    }
    public static void main(String[] args) {
        int[] arr={46, 34, 43};
        slectionSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
