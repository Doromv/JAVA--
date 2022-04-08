package 树;

/**
 * @author Doromv
 * @create 2022-03-28-9:52
 */
//是否是满二叉树
public class isFT {
    static class returnType{
        int height;
        int nodes;
        boolean isFT;

        public returnType() {
        }

        public returnType(int height, int nodes, boolean isFT) {
            this.height = height;
            this.nodes = nodes;
            this.isFT = isFT;
        }
    }
    public static returnType isBFT(Node head){
        if(head==null){
            return new returnType(0,0,true);
        }
        boolean isFT=false;
        returnType leftData = isBFT(head.left);
        returnType rightData = isBFT(head.right);
        int nodes=leftData.nodes+rightData.nodes+1;
        int height=Math.max(leftData.height,rightData.height)+1;
        if(leftData.isFT==true&&rightData.isFT==true&&Math.pow(2,height-1)==nodes){
            isFT=true;
        }
        return new returnType(height,nodes,isFT);
    }
}
