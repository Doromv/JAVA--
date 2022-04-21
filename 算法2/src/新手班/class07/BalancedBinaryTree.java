package 新手班.class07;

/**
 * @author Doromv
 * @create 2022-04-18-16:25
 */
//给定一个二叉树，判断它是否是高度平衡的二叉树。
//本题中，一棵高度平衡二叉树定义为：
//一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
public class BalancedBinaryTree {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
    public  class Info {
        public boolean isBalanced;
        public int height;

        public Info(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }
    public boolean isBalanced(TreeNode root) {
        return f(root).isBalanced;
    }
    public Info f(TreeNode root){
        if(root==null){
            return new Info(true,0);
        }
        Info infoL=f(root.left);
        Info infoR=f(root.right);
        boolean isBalanced=infoL.isBalanced&&infoR.isBalanced&&Math.abs(infoR.height-infoL.height)<2;
        int height=Math.max(infoL.height,infoR.height)+1;
        return new Info(isBalanced,height);
    }
}
