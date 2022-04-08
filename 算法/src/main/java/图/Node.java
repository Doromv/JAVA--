package 图;

import java.util.ArrayList;

/**
 * @author Doromv
 * @create 2022-03-29-11:33
 */
public class Node {
    public int value;
    public int in;
    public int out;
    public ArrayList<Node> nexts;
    public ArrayList<Edge> edges;
    public Node(int value){
        this.value=value;
        in=0;
        out=0;
        nexts=new ArrayList<>();
        edges=new ArrayList<图.Edge>();
    }
}
