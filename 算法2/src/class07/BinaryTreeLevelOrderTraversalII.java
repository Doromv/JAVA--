package class07;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Doromv
 * @create 2022-04-18-15:53
 */
//给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
//示例 1：
//输入：root = [3,9,20,null,null,15,7]
//输出：[[15,7],[9,20],[3]]
//示例 2：
//输入：root = [1]
//输出：[[1]]
//示例 3：
//输入：root = []
//输出：[]
public class BinaryTreeLevelOrderTraversalII {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list=new LinkedList<>();
        if(root==null){
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size=queue.size();
            List<Integer> curList = new LinkedList<>();
            for(int i=0;i<size;i++){
                TreeNode cur=queue.poll();
                curList.add(cur.val);
                if(cur.left!=null){
                    queue.add(cur.left);
                }
                if(cur.right!=null){
                    queue.add(cur.right);
                }
            }
            list.add(0, curList);
        }
        return list;
    }
}
