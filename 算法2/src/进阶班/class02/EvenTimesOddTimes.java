package 进阶班.class02;

/**
 * @author Doromv
 * @create 2022-04-25-14:13
 */
public class EvenTimesOddTimes {
    // arr中，只有一种数，出现奇数次
    public static void printOddTimesNum1(int[] arr) {
        int eor=0;
        for (int i : arr) {
            eor^=i;
        }
        System.out.println(eor);
    }
    // arr中，有两种数，出现奇数次
    public static void printOddTimesNum2(int[] arr) {
        int eor=0;
        for (int i : arr) {
            eor^=i;
        }
        int rightOne=eor&(~eor+1);
        int roe=0;
        for (int i : arr) {
            if((i&rightOne)!=0){
                roe^=i;
            }
        }
        System.out.print(roe+" ");
        System.out.print(eor^roe);
    }
}
