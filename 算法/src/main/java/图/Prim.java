package 图;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author Doromv
 * @create 2022-03-31-11:44
 */
public class Prim {
    public static class EdgeComparator implements Comparator<Edge> {
        @Override
        public int compare(Edge edge1, Edge edge2) {
            return edge1.weight-edge2.weight;
        }
    }
    public static Set<Edge> primMST(Graph graph){
        PriorityQueue<Edge> priorityQueue=new PriorityQueue<>(new EdgeComparator());
        HashSet<Node> set=new HashSet<>();
        Set<Edge> result=new HashSet<>();
        for(Node node:graph.nodes.values()){
            if(!set.contains(node)){
                set.add(node);
                for(Edge edge:node.edges){
                    priorityQueue.add(edge);
                }
                while (!priorityQueue.isEmpty()){
                    Edge edge=priorityQueue.poll();
                    Node toNode=edge.to;
                    if(!set.contains(toNode)){
                        set.add(toNode);
                        result.add(edge);
                        for(Edge nextEdge:toNode.edges){
                            priorityQueue.add(nextEdge);
                        }
                    }
                }
            }
        }
        return result;
    }
}
