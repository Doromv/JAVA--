package 图;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Doromv
 * @create 2022-03-29-11:36
 */
public class Graph {
    public HashMap<Integer,Node> nodes;
    public HashSet<Edge> edges;
    public Graph(){
        nodes=new HashMap<>();
        edges=new HashSet<>();
    }
}
