package 排序;

/**
 * @author Doromv
 * @create 2022-04-05-15:52
 */
public class InsertSort {
    public static void insertSort1(int[] arr){
        if(arr==null||arr.length<2){
            return;
        }
        for(int end=1;end<arr.length;end++){
            int cur=end;
            while (cur-1>=0&&arr[cur]<arr[cur-1]){
                swap(arr,cur,cur-1);
                cur--;
            }
        }
    }
    public static void insertSort2(int[] arr){
        if(arr==null||arr.length<2){
            return;
        }
        for(int end=1;end<arr.length;end++){
           for (int pre=end-1;pre>=0&&arr[pre]>arr[pre+1];pre--){
                swap(arr,pre,pre+1);
            }
        }
    }
    static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public static void main(String[] args) {
        int[] arr=new int[]{3,6,7,1,2,4,5,8,9};
        insertSort1(arr);
        for (int i : arr) {
            System.out.print(i);
        }
    }
}
