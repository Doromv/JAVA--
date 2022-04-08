package 贪心;

import java.util.PriorityQueue;

/**
 * @author Doromv
 * @create 2022-04-02-17:38
 */
public class LessMoneySplitGold {
    public static int lessMoney(int [] arr){
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>();
        for(int i=0;i<arr.length;i++){
            priorityQueue.add(arr[i]);
        }
        int sum=0;
        int cur=0;
        while (priorityQueue.size()>1){
            cur=priorityQueue.poll()+priorityQueue.poll();
            sum+=cur;
            priorityQueue.add(sum);
        }
        return sum;
    }
}
