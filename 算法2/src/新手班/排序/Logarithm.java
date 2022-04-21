package 新手班.排序;

/**
 * @author Doromv
 * @create 2022-04-06-19:59
 */
//对数器
public class Logarithm {
    // 返回一个数组arr，arr长度[0,maxLen-1],arr中的每个值[0,maxValue-1]
    public static int[] lenRandomValueRandom(int maxLen,int maxValue){
        int len= (int) (Math.random()*maxLen);
        int[] ans=new int[len];
        for(int i=0;i<len;i++){
            ans[i]= (int) (Math.random()*maxValue);
        }
        return ans;
    }
    public static int[] copyArray(int[] arr){
        int[] temp=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            temp[i]=arr[i];
        }
        return temp;
    }
    public static boolean isSorted(int[] arr){
        if(arr.length<2||arr==null){
            return true;
        }
        int max=arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]<max){
                return false;
            }
            max=Math.max(max,arr[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        int maxLen=1000;
        int maxValue=1000;
        int testTime=100;
        for(int i=0;i<testTime;i++){
            int[] arr = lenRandomValueRandom(maxLen, maxValue);
            int[] temp = copyArray(arr);
            InsertSort.insertSort2(arr);
            if(!isSorted(arr)){
                System.out.print("flase");
            }
        }
        System.out.println("true");
    }
}
