package 二叉树;

/**
 * @author Doromv
 * @create 2022-03-29-8:42
 */
//求后继节点
public class getSuccessorNode {
    public class Node<V> {
        V value;
        Node left;
        Node right;
        Node parent;
    }
    public static Node getSuccessorNode(Node node) {
        if(node==null){
          return node;
        }
        if(node.right!=null){
            return getLeftMost(node.right);
        }else{
            Node parent = node.parent;
            while (parent!=null&&parent.left!=node){
                node=node.parent;
                parent=node.parent;
            }
            return parent;
        }
    }
    public static Node getLeftMost(Node node){
        if(node==null){
            return node;
        }
        while (node.left!=null){
        node=node.left;
        }
        return node;
    }
    }

