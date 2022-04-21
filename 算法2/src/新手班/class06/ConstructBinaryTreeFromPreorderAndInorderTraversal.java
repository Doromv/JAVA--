package 新手班.class06;

import java.util.HashMap;

/**
 * @author Doromv
 * @create 2022-04-15-15:45
 */
//从前序和序遍历构造二叉树
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
      public static class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode() {}
       TreeNode(int val) { this.val = val; }
       TreeNode(int val, TreeNode left, TreeNode right) {
           this.val = val;
           this.left = left;
           this.right = right;
       }
   }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }
        HashMap<Integer, Integer> valueIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            valueIndexMap.put(inorder[i], i);
        }
        return f(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, valueIndexMap);
    }
    public static TreeNode f(int[] pre, int L1, int R1, int[] in, int L2,int R2,
                             HashMap<Integer, Integer> valueIndexMap) {
        if(L1>R1){
            return null;
        }
        TreeNode head=new TreeNode(pre[L1]);
        if(L1==R1){
            return head;
        }
        int find=valueIndexMap.get(pre[L1]);
        head.left=f(pre,L1+1,L1+find-L2,in,L2,find-1,valueIndexMap);
        head.right=f(pre,L1+find-L2+1,R1,in,find+1,R2,valueIndexMap);
        return head;
    }
}
