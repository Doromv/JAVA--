package 链表;

/**
 * @author Doromv
 * @create 2022-03-24-8:11
 */
 class Node {
    public int value;
    public Node next;
    public Node rand;
    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
