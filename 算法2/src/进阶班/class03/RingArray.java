package 进阶班.class03;

/**
 * @author Doromv
 * @create 2022-04-29-16:07
 */
public class RingArray {
    public static class MyQueue {
        private int[] arr;
        private int pushIndex;
        private int pollIndex;
        private int size;
        private final int limit;

        public MyQueue(int limit) {
            this.arr = new int[limit];
            this.pushIndex =0;
            this.pollIndex =0;
            this.size = 0;
            this.limit = limit;
        }

        public void push(int value) {
            if(size==limit){
                throw new RuntimeException("队列满了，不能再添加了");
            }
            size++;
            arr[pushIndex]=value;
            pushIndex=nextIndex(pushIndex);
        }

        public int pop() {
            if(size==0){
                throw new RuntimeException("队列空了，不能再拿了");
            }
            size--;
            int ans=arr[pollIndex];
            pollIndex=nextIndex(pollIndex);
            return ans;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        private int nextIndex(int i) {
            return i<limit-1? i+1:0;
        }
    }
    public static class MyStack {
        private int[] arr;
        private int index;
        private int size;
        private final int limit;

        public MyStack(int limit) {
            this.arr = new int[limit];
            this.index =0;
            this.size = 0;
            this.limit = limit;
        }
        public void add(int value) {
            if(size==limit){
                throw new RuntimeException("队列满了，不能再添加了");
            }
            size++;
            arr[index]=value;
            index=addIndex(index);
        }

        public int pop() {
            if(size==0){
                throw new RuntimeException("队列空了，不能再拿了");
            }
            size--;
            int ans=arr[--index];
            return ans;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        private int addIndex(int i) {
            return i<limit-1? i+1:0;
        }

    }
}
