package 树;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Doromv
 * @create 2022-03-26-10:35
 */
public class binaryTreeWidth {
    public static int binaryTreeWidth(Node head){
        if(head!=null){
            Queue<Node> queue=new LinkedList<>();
            queue.add(head);
            HashMap<Node,Integer> levelMap=new HashMap<>();
            int curLevel=1;
            int curLevelNodes=0;
            int maxWidth=Integer.MIN_VALUE;
            while (!queue.isEmpty()){
                Node cur=queue.poll();
                int curNodeinLevel=levelMap.get(cur);
                if(curNodeinLevel==curLevel){
                    curLevelNodes++;
                }else {
                    maxWidth=Math.max(maxWidth,curLevelNodes);
                    curLevel+=1;
                    curLevelNodes=1;
                }
                if(cur.left!=null){
                    levelMap.put(cur.left,curNodeinLevel+1);
                    queue.add(cur.left);
                }
                if(cur.right!=null){
                    levelMap.put(cur.left,curNodeinLevel+1);
                    queue.add(cur.right);
                }
            }
            return maxWidth;
        }
        return 0;
    }
}
