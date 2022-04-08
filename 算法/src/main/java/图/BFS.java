package 图;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Doromv
 * @create 2022-03-29-12:44
 */
//图的宽度优先遍历
public class BFS {
    public static void bfs(Node node){
        if(node==null){
            return;
        }
        Queue<Node> queue=new LinkedList<>();
        HashSet<Node> set=new HashSet<>();
        queue.add(node);
        set.add(node);
        while(!queue.isEmpty()){
            Node cur=queue.poll();
            System.out.println(cur.value);
            for (Node i:cur.nexts){
                if(!set.contains(i)){
                    queue.add(i);
                    set.add(i);
                }
            }
        }
    }
}
