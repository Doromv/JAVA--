package 图;

import java.util.HashSet;
import java.util.Stack;

/**
 * @author Doromv
 * @create 2022-03-29-12:53
 */
//图的深度优先遍历
public class DFS {
    public static void dfs(Node node){
        if(node==null){
            return;
        }
        Stack<Node> stack=new Stack<>();
        HashSet<Node> set=new HashSet<>();
        stack.add(node);
        set.add(node);
        System.out.println(node.value);
        while (!stack.isEmpty()){
            Node cur = stack.pop();
            for (Node i: cur.nexts){
                if(!set.contains(i)){
                    System.out.println(i.value);
                    stack.push(cur);
                    stack.push(i);
                    set.add(i);
                    break;
                }
            }

        }
    }
}
