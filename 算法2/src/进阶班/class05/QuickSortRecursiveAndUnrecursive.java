package 进阶班.class05;

import java.util.Stack;

import static 进阶班.class05.PartitionAndQuickSort.partition2;
import static 进阶班.class05.PartitionAndQuickSort.swap;

/**
 * @author Doromv
 * @create 2022-05-03-17:40
 */

//辅助类
public class QuickSortRecursiveAndUnrecursive {
    public static class Op {
        public int l;
        public int r;

        public Op(int left, int right) {
            l = left;
            r = right;
        }
    }
// 快排非递归版本
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        swap(arr, (int) (Math.random() * N), N - 1);
        int[] equalArea = partition2(arr, 0, N - 1);
        int el = equalArea[0];
        int er = equalArea[1];
        Stack<Op> stack = new Stack<>();
        stack.push(new Op(0, el - 1));
        stack.push(new Op(er + 1, N - 1));
        while (!stack.isEmpty()) {
            Op op = stack.pop();
            if (op.l < op.r) {
                swap(arr, op.l + (int) (Math.random() * (op.r - op.l + 1)), op.r);
                equalArea = partition2(arr, op.l, op.r);
                el = equalArea[0];
                er = equalArea[1];
                stack.push(new Op(op.l, el - 1));
                stack.push(new Op(er + 1, op.r));
            }
        }
    }
}
