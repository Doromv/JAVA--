package 进阶班.class03;

/**
 * @author Doromv
 * @create 2022-04-29-17:53
 */
public class GetMax {
    public static int getMax(int[] arr) {
        return process(arr, 0,arr.length-1);
    }
    public static int process(int[] arr, int L, int R) {
        if(L==R){
            return arr[L];
        }
        int M=L+((R-L)>>1);
        return Math.max(process(arr,L,M),process(arr,M+1, R));
    }
}
