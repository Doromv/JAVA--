package Unity;

import com.sun.prism.sw.SWPipeline;

/**
 * @author Doromv
 * @create 2022-03-22-8:35
 */
public class swap {
    public static void swap(int[] arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
