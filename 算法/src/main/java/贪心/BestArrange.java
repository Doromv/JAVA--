package 贪心;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Doromv
 * @create 2022-04-02-16:37
 */
public class BestArrange {
    public static class Program{
        public int start;
        public int end;

        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static class ProgramComparator implements Comparator<Program> {
        @Override
        public int compare(Program program, Program t1) {
            return program.end-t1.end;
        }
    }
    public static int bestArrange(Program[] programs,int timePoint){
        Arrays.sort(programs,new ProgramComparator());
        int result=0;
        for(int i=0;i<programs.length;i++){
            if(timePoint<programs[i].start){
                result++;
                timePoint=programs[i].end;
            }
        }
        return result;
    }
}
