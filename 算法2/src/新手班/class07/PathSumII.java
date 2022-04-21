package 新手班.class07;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Doromv
 * @create 2022-04-18-16:59
 */
//给你二叉树的根节点 root 和一个整数目标和 targetSum ，
// 找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
public class PathSumII {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> list=new LinkedList<>();
        int sum=0;
        if (root == null) {
            return list;
        }
        ArrayList<Integer> path = new ArrayList<>();
        f(root, sum,targetSum, path, list);
        return list;
    }
    public  List<List<Integer>> f(TreeNode root,int preSum, int targetSum,List<Integer> prePath,List<List<Integer>> list) {
        if(root.left==null&&root.right==null) {
            if (root.val + preSum == targetSum) {
                prePath.add(root.val);
                list.add(copy(prePath));
                prePath.remove(prePath.size()-1);
            }
        }
            preSum+=root.val;
            prePath.add(root.val);
            if(root.left!=null){
            f(root.left,preSum, targetSum, prePath,list);
            }
            if(root.right!=null){
                f(root.right,preSum, targetSum, prePath,list);
            }
             prePath.remove(prePath.size()-1);
            return list;
        }
    public static List<Integer> copy(List<Integer> path) {
        List<Integer> ans = new ArrayList<>();
        for (Integer num : path) {
            ans.add(num);
        }
        return ans;
    }
    }
