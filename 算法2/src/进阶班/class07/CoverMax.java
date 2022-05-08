package 进阶班.class07;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * @author Doromv
 * @create 2022-05-08-14:24
 */
public class CoverMax {
    public static int maxCover(int[][] m) {
        Line[] lines=new Line[m.length];
        for (int i = 0; i < m.length; i++) {
            lines[i]=new Line(m[i][0],m[i][1]);
        }
        Arrays.sort(lines, (o1, o2) -> o1.end-o1.end);
        int max=0;
        PriorityQueue<Integer> heap=new PriorityQueue<>();
        for (int i = 0; i < lines.length; i++) {
            while (!heap.isEmpty()&&heap.peek()<=lines[i].start){
                heap.poll();
            }
            heap.add(lines[i].end);
            max=Math.max(max, heap.size());
        }
        return max;
    }
    public static class Line{
        public int start;
        public int end;

        public Line(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
