package 递归;

import javax.sound.midi.MidiChannel;

/**
 * @author Doromv
 * @create 2022-03-22-10:49
 */
public class MergeSort {
    public static void process(int[] arr,int L,int R) {
        if(L==R){
            return;
        }
        int mid=L+((R-L)>>1);
        process(arr,L,mid);
        process(arr,mid+1,R);
        merge(arr,L,mid,R);
    }

    public static void merge(int[] arr,int L,int M,int R) {
        int[] help=new int[R-L+1];
        int i=0;
        int p1= L;
        int p2=M+1;
        while (p1<=M&&p2<=R){
            help[i++]=arr[p1]<arr[p2]? arr[p1++]:arr[p2++];
        }
        while (p1<=M){
            help[i++]=arr[p1++];
        }
        while (p2<=R){
            help[i++]=arr[p2++];
        }
        for (i=0;i<help.length;i++){
            arr[L+i]=help[i];
        }
    }
    public static void main(String[] args) {
        int[] arr={46, 34, 43,2,2334,43,4356,4575,4575,474};
        process(arr,0,9);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
