package class03;

/**
 * @author Doromv
 * @create 2022-04-09-16:24
 */
public class BSAwesome {
    // arr 相邻的数不相等,返回出某个局部最小的数的index
    public static int oneMinIndex(int[] arr) {
        if(arr.length==0){
            return -1;
        }
        if(arr.length==1){
            return 0;
        }
        if(arr[0]<arr[1]){
            return 0;
        }
        if(arr[arr.length-1]<arr[arr.length-2]){
            return arr.length-1;
        }
        int l=0;
        int r=arr.length-1;
        while (l<r-1){
            int mid=l+(r-l)/2;
            if(arr[mid]<arr[mid+1]&&arr[mid]<arr[mid-1]){
                return mid;
            }else if(arr[mid]>arr[mid-1]){
                r=mid-1;
            }else {
                l=mid+1;
            }
        }
        return arr[l]<arr[r]? l:r;
    }
    // 生成相邻数不相等的随机数组
    public static int[] randomArray(int maxLen, int maxValue) {
        int[] arr=new int[(int) (Math.random()*(maxLen+1))];
        for (int i = 1; i < arr.length; i++) {
            do{
                arr[i]= (int) (Math.random()*(maxValue+1))-(int) (Math.random()*(maxValue));
            }while (arr[i]==arr[i-1]);
        }
        return arr;
    }
    //test
    public static boolean check(int[] arr, int minIndex) {
        if (arr.length == 0) {
            return minIndex == -1;
        }
        int left = minIndex - 1;
        int right = minIndex + 1;
        boolean leftBigger = left >= 0 ? arr[left] > arr[minIndex] : true;
        boolean rightBigger = right < arr.length ? arr[right] > arr[minIndex] : true;
        return leftBigger && rightBigger;
    }
    public static void main(String[] args) {
        int maxLen = 100;
        int maxValue = 200;
        int testTime = 1000000;
        boolean falg=true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = randomArray(maxLen, maxValue);
            int result = oneMinIndex(arr);
            if (!check(arr, result)) {
                falg=falg;
                break;
            }
        }
        System.out.println(falg);
    }
}
