package 简单排序;

import Unity.swap;

/**
 * @author Doromv
 * @create 2022-03-22-9:06
 */
public class bubbleSort {
    public static void bubbleSort(int[] arr) {
        if(arr==null||arr.length<2){
            return;
        }
        for(int e= arr.length-1;e>0;e--){
            for(int i=0;i<e;i++){
                if(arr[i]>arr[i+1]){
                    swap.swap(arr, i, i + 1);
                }
            }
        }

    }
    public static void main(String[] args) {
        int[] arr={46, 34, 43};
        bubbleSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
