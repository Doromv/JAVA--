package 简单排序;

import Unity.swap;

/**
 * @author Doromv
 * @create 2022-03-22-9:49
 */
public class insertionSort {
    public static void insertionSort(int[] arr) {
        if(arr.length<2||arr==null) {
            return;
        }
        for(int i=1;i<arr.length;i++){
            for(int j=i-1;j>=0&&arr[j]>arr[j+1];j--){
                swap.swap(arr,j,j+1);
            }
        }
    }
    public static void main(String[] args) {
        int[] arr={46, 34, 43};
        insertionSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
