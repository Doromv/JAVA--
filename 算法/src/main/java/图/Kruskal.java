package 图;

import jdk.nashorn.internal.ir.ReturnNode;

import java.util.*;

/**
 * @author Doromv
 * @create 2022-03-31-8:37
 */
public class Kruskal {
    public static class Myset{
        public HashMap<Node, List<Node>> setMap=new HashMap<>();
        public Myset(List<Node> list){
            for(Node cur:list){
                List<Node> set=new ArrayList<>();
                set.add(cur);
                setMap.put(cur,set);
            }
        }
        public boolean isSameSet(Node from,Node to){
            List<Node> fromSet=setMap.get(from);
            List<Node> toSet=setMap.get(to);
            return fromSet==toSet;
        }
        public void union(Node from,Node to){
            List<Node> fromSet=setMap.get(from);
            List<Node> toSet=setMap.get(to);
            for (Node toNode:toSet){
                fromSet.add(toNode);
                setMap.put(toNode,fromSet);
            }
        }
    }
    public static class EdgeComparator implements Comparator<Edge> {
        @Override
        public int compare(Edge edge1, Edge edge2) {
            return edge1.weight-edge2.weight;
        }
    }
    public static Set<Edge> kruskalMST(Graph graph){
        Myset myset = new Myset((List<Node>) graph.nodes.values());
        PriorityQueue<Edge> priorityQueue=new PriorityQueue<>(new EdgeComparator());
        for(Edge edge:graph.edges){
            priorityQueue.add(edge);
        }
        Set<Edge> result=new HashSet<>();
        while (!priorityQueue.isEmpty()){
            Edge edge=priorityQueue.poll();
            if(!myset.isSameSet(edge.from,edge.to)){
                result.add(edge);
                myset.union(edge.from,edge.to);
            }
        }
        return result;
    }
}
