package 排序;

/**
 * @author Doromv
 * @create 2022-04-04-17:49
 */
public class SelectSort {
    public static void main(String[] args) {
        int arr[]={2,5,7,9,4,3,6,1,8};
        Sort1(arr);
        for (int i : arr) {
            System.out.print(i+",");
        }
    }
    public static void Sort1(int[] arr){
        for (int j=0;j<arr.length-1;j++){
            int minPos=j;
            for(int i=j+1;i<arr.length;i++){
                minPos=arr[i]<arr[minPos]? i:minPos;
            }
            swap(arr,j,minPos);
//            System.out.print("经历过第"+j+"次循环后的数组内容： ");
//            print(arr);
//            System.out.println();
        }
    }
    public static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    static void print(int[] arr){
        for (int i : arr) {
            System.out.print(i+",");
        }
    }
}
