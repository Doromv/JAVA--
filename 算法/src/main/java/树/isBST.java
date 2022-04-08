package 树;

/**
 * @author Doromv
 * @create 2022-03-28-9:20
 */
//是否是搜索二叉树
public class isBST {
    static class returnType{
        int max;
        int min;
        boolean isBST;

        public returnType() {
        }

        public returnType(int max, int min, boolean isBST) {
            this.max = max;
            this.min = min;
            this.isBST = isBST;
        }
    }
    public static returnType isBST(Node<Integer> head){
        if(head==null){
            return null;
        }
        returnType leftData = isBST(head.left);
        returnType rightData = isBST(head.right);
        boolean isBST =true;
        int min=head.value;
        int max=head.value;
       if(leftData!=null){
           min= Math.min(leftData.min,min);
           max=Math.max(leftData.max,max);
       }
        if(rightData!=null){
            min= Math.min(rightData.min,min);
            max=Math.max(rightData.max,max);
        }
        if(leftData!=null&&(!leftData.isBST||leftData.max>=head.value)){
            isBST =false;
        }
        if(rightData!=null&&(!rightData.isBST||rightData.min<=head.value)){
            isBST =false;
        }
        return new returnType(min,max,isBST);
    }
}
