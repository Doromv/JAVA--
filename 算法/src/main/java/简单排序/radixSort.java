package 简单排序;

/**
 * @author Doromv
 * @create 2022-03-22-17:16
 */
public class radixSort {
    public static void radixSort(int[] arr) {
        if(arr.length<2||arr==null) {
            return;
        }
        radixSort(arr,0,arr.length-1,maxbits(arr));
    }
    public static int maxbits(int[] arr){
        int max=Integer.MIN_VALUE;//Integer.MIN_VALUE代表系统最小值
        for(int i=0;i<arr.length;i++){
            max= Math.max(max,arr[i]);
        }
        int res=0;
        while (max!=0){
            res++;
            max/=10;
        }
        return res;
    }
    public static void radixSort(int[] arr,int L,int R,int dight){
        int[] bucket=new int[R-L+1];
        final int radix=10;
        int i=0;
        int j=0;
        for(int d=1;d<=dight;d++){
            int[] count=new int[radix];
            for (i=L;i<=R;i++){
                j=getDigit(arr[i],d);
                count[j]++;
            }
            for(i=1;i<radix;i++){
                count[i]+=count[i-1];
            }
            for (i=R;i>=L;i--){
                j=getDigit(arr[i],d);
                bucket[count[j]-1]=arr[i];
                count[j]--;
            }
            for(i=L,j=0;i<=R;i++,j++){
                arr[i]=bucket[j];
            }
        }
    }
    public static int getDigit(int x,int d){
        return ((x/((int)Math.pow(10,d-1)))%10);
    }
    public static void main(String[] args) {
        int[] arr={46, 34, 43};
        radixSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
