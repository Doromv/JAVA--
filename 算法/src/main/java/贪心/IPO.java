package 贪心;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Doromv
 * @create 2022-04-03-15:29
 */
//投资问题
public class IPO {
    public static class Node{
        public int p;
        public int c;

        public Node(int p, int c) {
            this.p = p;
            this.c = c;
        }
    }
    public static class MinCostComparator implements Comparator<Node>{

        @Override
        public int compare(Node node, Node t1) {
            return node.c-t1.c;
        }
    }
    public static class MaxProfitComparator implements Comparator<Node>{

        @Override
        public int compare(Node node, Node t1) {
            return t1.p-node.p;
        }
    }
    public static int findMaximizedCapital(int k,int w,int[] Profits,int[] Capital){
        PriorityQueue<Node> minCostQ=new PriorityQueue(new MinCostComparator());
        PriorityQueue<Node> maxProfitQ=new PriorityQueue(new MaxProfitComparator());
        for(int i=0;i<Profits.length;i++){
            minCostQ.add(new Node(Profits[i],Capital[i]));
        }
        for(int i=0;i<k;i++){
            while (!minCostQ.isEmpty()&&minCostQ.peek().c<=w){
                maxProfitQ.add(minCostQ.poll());
            }
            if(maxProfitQ.isEmpty()){
                return w;
            }
            w+=maxProfitQ.poll().p;
        }
        return w;
    }
}
