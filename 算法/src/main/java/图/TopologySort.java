package 图;

import java.util.*;

/**
 * @author Doromv
 * @create 2022-03-31-9:27
 */
public class TopologySort {
    public static List<Node> sprtedTopology(Graph graph){
        HashMap<Node,Integer> map=new HashMap<>();
        Queue<Node> zeroInQueue=new LinkedList<>();
        for(Node node:graph.nodes.values()){
            map.put(node,node.in);
            if(node.in==0){
                zeroInQueue.add(node);
            }
        }
        List<Node> result=new ArrayList<>();
        while (!zeroInQueue.isEmpty()){
            Node cur = zeroInQueue.poll();
            result.add(cur);
            for(Node next:cur.nexts){
                map.put(next,map.get(next)-1);
                if(map.get(next)==0){
                    zeroInQueue.add(next);
                }
            }
        }
        return result;
    }
}
