package 新手班.class02;

/**
 * @author Doromv
 * @create 2022-04-06-16:58
 */
public class RandToRand {
    // 此函数只能用，不能修改
    // 等概率返回1~5
    public static int f1() {
        return (int) (Math.random() * 5) + 1;
    }

    //在1~5 等概率得到0和1
    public static int f2() {
        int ans = 0;
        do {
            ans = f1();
        } while (ans == 3);
        return ans;
    }

    // 等概率返回=0~6
    public static int f3() {
        int ans = 0;
        do {
            ans = (f2() << 2) + (f2() << 1) + (f2() << 0);
        } while (ans == 7);
        return ans;
    }

    public static int f4() {
        return f3() + 1;
    }
}
