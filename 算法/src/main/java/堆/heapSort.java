package 堆;

import Unity.swap;
import com.sun.org.apache.bcel.internal.generic.SWAP;

/**
 * @author Doromv
 * @create 2022-03-22-16:19
 */
public class heapSort {
    public static void heapInsert(int[] arr,int index) {
        while(arr[index]>arr[(index-1)/2]){
            swap.swap(arr,index,(index-1)/2);
            index=(index-1)/2;
        }
    }
    public static void heapify(int[] arr,int index,int heapSize){
        int left=index*2+1;
        while (left<heapSize){
            int lagerest=left+1<heapSize&&arr[left+1]>arr[left] ? left+1:left;
            lagerest=arr[lagerest]>arr[index]? lagerest:index;
            if(lagerest==index){
                break;
            }
            swap.swap(arr,index,lagerest);
            index=lagerest;
            left=index*2+1;
        }
    }
    public static void heapSort(int[] arr){
        if(arr==null||arr.length<2){
            return;
        }
        for(int i=0;i<arr.length;i++){
            heapInsert(arr,i);
        }
        int heapSize=arr.length;
        swap.swap(arr,0,--heapSize);
        while (heapSize>0){
            heapify(arr,0,heapSize);
            swap.swap(arr,0,--heapSize);
        }
    }
    public static void main(String[] args) {
        int[] arr={46, 34, 43,2,2334,43,4356,4575,4575,474};
        heapSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
