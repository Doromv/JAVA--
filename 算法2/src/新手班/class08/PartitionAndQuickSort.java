package 新手班.class08;

/**
 * @author Doromv
 * @create 2022-04-21-15:09
 */
public class PartitionAndQuickSort {
    public static void splitNum1(int[] arr) {
        int lessR=-1;
        int index=0;
        while (index<arr.length){
            if(arr[index]<arr[arr.length-1]){
                swap(arr, ++lessR,index++);
            }else {
                index++;
            }
        }
    }
    public static void splitNum2(int[] arr) {
        int lessR=-1;
        int moreL=arr.length-1;
        int index=0;
        while (index<moreL){
            if(arr[index]<arr[arr.length-1]){
                swap(arr, ++lessR,index++);
            }else if(arr[index]>arr[arr.length-1]) {
                swap(arr, --moreL,index);
            }else {
                index++;
            }
        }
    }
    public static void quickSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }
    public static void process(int[] arr, int L, int R) {
        if(L>=R){
            return;
        }
        int[] equal=partition(arr,L,R);
        process(arr,L, equal[0]-1);
        process(arr, equal[1]+1,R);
    }
    public static int[] partition(int[] arr, int L, int R) {
        int lessR = L - 1;
        int moreL = R;
        int index = L;
        while (index<moreL){
            if(arr[index]<arr[R]){
                swap(arr,++lessR,index++);
            }else if(arr[index]>arr[R]){
                swap(arr,--moreL, index);
            }else{
                index++;
            }
        }
        swap(arr, moreL,R);
        return new int[]{lessR+1,moreL};
    }
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
