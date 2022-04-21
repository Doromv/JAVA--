package 新手班.class08;

/**
 * @author Doromv
 * @create 2022-04-21-14:37
 */
public class MergeSort {
    public static void mergeSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }
    public static void process(int[] arr,int l,int r){
        if(l==r){
            return;
        }
        int mid=l+((r-l)>>1);
        process(arr,l, mid);
        process(arr,mid+1,r);
        merge(arr,l,mid,r);
    }
    public static void merge(int[] arr,int l,int m,int r){
        int[] help=new int[r-l+1];
        int i=0,p1=l,p2=m+1;
        while (p1<=m&&p2<=r){
            help[i++]=arr[p1]<arr[p2]?arr[p1++]:arr[p2++];
        }
        while (p1 <= m) {
            help[i++]=arr[p1++];
        }
        while (p2 <= r) {
            help[i++]=arr[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            arr[l+j]=help[j];
        }
    }
}
