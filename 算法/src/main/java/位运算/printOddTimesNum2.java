package 位运算;

/**
 * @author Doromv
 * @create 2022-03-22-9:20
 */
public class printOddTimesNum2 {
    public static void printOddTimesNum2(int[] arr) {
        //一组数组内，有只有两中数字出现了奇数次，例如{1，1，1，1，5，5，5，3，3，3，2，2，2，2，7，7，7，7}
        int eor=0;
        for(int cur: arr){
            eor^=cur;
        }
        //eor=a^b
        //eor!=0
        //二进制形式，eor必然有一个位置上是1
        int rightOne=eor&(~eor+1);//取出eor最右边的1,形式例如 000000000001000
        int onlyOne=0;
        for(int cur:arr){
            if((cur&rightOne)==1){
                onlyOne^=cur;
            }

        }
        System.out.println(onlyOne+" "+(eor^onlyOne));
    }

    public static void main(String[] args) {
        int[] arr={2,3,4,4};
        printOddTimesNum2(arr);
    }

}
