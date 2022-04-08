package 递归;

/**
 * @author Doromv
 * @create 2022-03-22-10:32
 */
public class GetMax {
    public static int process(int[] arr,int L,int R) {
        if(L==R){
            return arr[L];
        }
        int mid=L+((R-L)>>1);
        int leftMax=process(arr,L,mid);
        int rightMax=process(arr,mid+1,R);
        return Math.max(leftMax,rightMax);
    }
    public static void main(String[] args) {
        int[] arr={46, 34, 43,2,2334,43,4356,4575,4575,474};
        int process = process(arr, 0, 9);
        System.out.println(process);
    }
}
