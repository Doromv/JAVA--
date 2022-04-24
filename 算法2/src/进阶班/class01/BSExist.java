package 进阶班.class01;

import java.util.Arrays;

/**
 * @author Doromv
 * @create 2022-04-24-15:35
 */
public class BSExist {
    public static boolean exist(int[] arr, int num) {
        if(arr ==null|| arr.length==0){
            return false;
        }
        int l=0;
        int r= arr.length-1;
        int m=0;
        while (l<=r){
             m=l+((r-l)>>1);
            if(arr[m]==num){
                return true;
            }else if(arr[m]>num){
                r=m-1;
            }else {
                l=m+1;
            }
        }
        return false;
    }
    //for test
    public static boolean comparator(int[] arr,int num){
        for (int i : arr) {
            if(i== num){
                return true;
            }
        }
        return false;
    }
    //for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr=new int[(int) (Math.random()*(maxSize+1))];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=(int) (Math.random()*(maxValue+1))-(int) (Math.random()*maxValue);
        }
        return arr;
    }
    // for test
    public static void main(String[] args) {
        int testTime=10000;
        int maxValue=10;
        int maxSize=100;
        boolean succeed=true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            Arrays.sort(arr);
            int value = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
            if(comparator(arr,value)!=exist(arr,value)){
                succeed=false;
                break;
            }
        }
        System.out.println(succeed);
    }
}
