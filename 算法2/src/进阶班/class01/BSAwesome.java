package 进阶班.class01;

/**
 * @author Doromv
 * @create 2022-04-24-16:19
 */
public class BSAwesome {
    //局部最小
    public static int getLessIndex(int[] arr) {
        if(arr.length==0||arr==null){
            return -1;
        }
        if(arr.length==1||arr[0]<arr[1]){
            return 0;
        }
        if(arr[arr.length-1]<arr[arr.length-2]){
            return arr.length-1;
        }
        int l=1;
        int r=arr.length-2;
        int m=0;
        while (l<=r){
            m=l+((r-l)>>1);
            if(arr[m]>arr[m-1]){
                r=m-1;
            }else if(arr[m]>arr[m+1]){
                l=m+1;
            }else {
                return m;
            }
        }
        return -1;
    }
    // for test
    public static boolean isRight(int[] arr, int index) {
        if (arr.length <= 1) {
            return true;
        }
        if (index == 0) {
            return arr[index] < arr[index + 1];
        }
        if (index == arr.length - 1) {
            return arr[index] < arr[index - 1];
        }
        return arr[index] < arr[index - 1] && arr[index] < arr[index + 1];
    }
    // for test
    // 生成相邻不相等的数组
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) (Math.random() * maxSize) + 1];
        arr[0] = (int) (Math.random() * maxValue) - (int) (Math.random() * maxValue);
        for (int i = 1; i < arr.length; i++) {
            do {
                arr[i] = (int) (Math.random() * maxValue) - (int) (Math.random() * maxValue);
            } while (arr[i] == arr[i - 1]);
        }
        return arr;
    }
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 30;
        int maxValue = 100;
        boolean succeed=true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            int ans = getLessIndex(arr);
            if (!isRight(arr, ans)) {
                succeed=false;
                break;
            }
        }
        System.out.println(succeed);
    }
}
