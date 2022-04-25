package 进阶班.class02;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Doromv
 * @create 2022-04-25-14:23
 */
// 输入一定能够保证，数组中所有的数都出现了M次，只有一种数出现了K次
// 1 <= K < M
// 返回这种数
public class KM {
    public static int km(int[] arr, int k, int m) {
        int[] help=new int[32];
        for (int num : arr) {
            for (int i = 0; i < 32; i++) {
                help[i]+=(num>>i)&1;
            }
        }
        int ans=0;
        for (int i = 0; i < help.length; i++) {
            help[i]%=m;
            if(help[i]!=0){
                ans|=1<<i;
            }
        }
        return ans;
    }
    //for test
    public static int test(int[] arr, int k, int m) {
        HashMap<Integer,Integer> map= new HashMap<>();
        for (Integer num :arr) {
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }else {
                map.put(num, 1);
            }
        }
        int ans=0;
        for (Integer num : map.keySet()) {
            if(map.get(num)==k){
                ans=num;
                break;
            }
        }
        return ans;
    }
    //for test
    public static int[] randomArray(int maxKinds, int range, int k, int m) {
        // 真命天子出现的值
        int ktimeNum=randomNumber(range);
        // 真命天子出现的次数
        int times=k;
        //一共有几种数(至少要有两种)
        int numKinds=(int)(Math.random()*maxKinds)+2;
        int[] arr=new int[times+(numKinds-1)*m];
        int index=0;
        for (;index<times;index++){
            arr[index]=ktimeNum;
        }
        numKinds--;
        HashSet<Integer> set = new HashSet<>();
        set.add(ktimeNum);
        while (numKinds!=0){
            int curNum=0;
            do{
                curNum=randomNumber(range);
            }while (set.contains(curNum));
            set.add(curNum);
            numKinds--;
            for (int i = 0; i < m; i++) {
                arr[index++]=curNum;
            }
        }
        //打乱arr
        for (int i = 0; i < arr.length; i++) {
            // i 位置的数，我想随机和j位置的数做交换
            int j = (int) (Math.random() * arr.length);
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
        return arr;
    }
    //for test
    // [-range, +range]
    public static int randomNumber(int range) {
        return (int) (Math.random() * (range + 1)) - (int) (Math.random() * range );
    }
    //for test
    public static void main(String[] args) {
        boolean flag=true;
        int kinds = 5;
        int range = 30;
        int testTime = 100000;
        int max = 9;
        for (int i = 0; i < testTime; i++) {
            int a = (int) (Math.random() * max) + 1;
            int b = (int) (Math.random() * max) + 1;
            int k = Math.min(a, b);
            int m = Math.max(a, b);
            // k < m
            if (k == m) {
                m++;
            }
            int[] arr = randomArray(kinds, range, k, m);
            int ans1 = test(arr, k, m);
            int ans3 = km(arr, k, m);
            if ( ans1 != ans3) {
                flag=false;
            }
        }
        System.out.println(flag);
    }
}
