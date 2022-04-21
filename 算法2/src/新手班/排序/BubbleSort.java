package 新手班.排序;

/**
 * @author Doromv
 * @create 2022-04-05-15:35
 */
public class BubbleSort {
    public static void BubbleSort(int[] arr){
        if(arr==null||arr.length<2){
            return;
        }
        for (int i=arr.length-1;i>=0;i--){
            for(int j=1;j<=i;j++){
                if(arr[j-1]>arr[j]){
                    swap(arr,j,j-1);
                }
            }
        }
    }
    static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
