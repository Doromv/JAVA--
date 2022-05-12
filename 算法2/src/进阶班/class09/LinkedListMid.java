package 进阶班.class09;

import java.util.ArrayList;

/**
 * @author Doromv
 * @create 2022-05-12-16:22
 */
public class LinkedListMid {
    public static class Node {
        public int value;
        public Node next;

        public Node(int v) {
            value = v;
        }
    }
    //奇数-返回中间节点
    //偶数-返回中间两个节点当中偏上的节点
    public static Node midOrUpMidNode(Node head) {
        if(head==null||head.next==null||head.next.next==null){
            return head;
        }
        Node slow=head.next;
        Node fast=head.next.next;
        while (fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    //奇数-返回中间节点
    //偶数-返回中间两个节点当中偏下的节点
    public static Node midOrDownMidNode(Node head) {
        if(head==null||head.next==null){
            return head;
        }
        Node slow=head.next;
        Node fast=head.next;
        while (fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    //奇数-返回中间节点的前一个节点
    //偶数-返回中间两个节点当中偏上的节点的前一个节点
    public static Node midOrUpMidPreNode(Node head) {
        if(head==null||head.next==null||head.next.next==null){
            return null;
        }
        Node slow=head;
        Node fast=head.next.next;
        while (fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    //奇数-返回中间节点的前一个节点
    //偶数-返回中间两个节点当中偏下的节点的前一个节点
    public static Node midOrDownMidPreNode(Node head) {
        if(head==null||head.next.next==null){
            return null;
        }
        if (head.next.next==null) {
            return head;
        }
        Node slow=head;
        Node fast=head.next;
        while (fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }

    public static Node right1(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        ArrayList<Node> arr = new ArrayList<>();
        while (cur != null) {
            arr.add(cur);
            cur = cur.next;
        }
        return arr.get((arr.size() - 1) / 2);
    }

    public static Node right2(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        ArrayList<Node> arr = new ArrayList<>();
        while (cur != null) {
            arr.add(cur);
            cur = cur.next;
        }
        return arr.get(arr.size() / 2);
    }

    public static Node right3(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        Node cur = head;
        ArrayList<Node> arr = new ArrayList<>();
        while (cur != null) {
            arr.add(cur);
            cur = cur.next;
        }
        return arr.get((arr.size() - 3) / 2);
    }

    public static Node right4(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node cur = head;
        ArrayList<Node> arr = new ArrayList<>();
        while (cur != null) {
            arr.add(cur);
            cur = cur.next;
        }
        return arr.get((arr.size() - 2) / 2);
    }

    public static void main(String[] args) {
        Node test = null;
        test = new Node(0);
        test.next = new Node(1);
        test.next.next = new Node(2);
        test.next.next.next = new Node(3);
        test.next.next.next.next = new Node(4);
        test.next.next.next.next.next = new Node(5);
        test.next.next.next.next.next.next = new Node(6);
        test.next.next.next.next.next.next.next = new Node(7);
        test.next.next.next.next.next.next.next.next = new Node(8);

        Node ans1 = null;
        Node ans2 = null;

        ans1 = midOrUpMidNode(test);
        ans2 = right1(test);
        System.out.println(ans1 != null ? ans1.value : "无");
        System.out.println(ans2 != null ? ans2.value : "无");

        ans1 = midOrDownMidNode(test);
        ans2 = right2(test);
        System.out.println(ans1 != null ? ans1.value : "无");
        System.out.println(ans2 != null ? ans2.value : "无");

        ans1 = midOrUpMidPreNode(test);
        ans2 = right3(test);
        System.out.println(ans1 != null ? ans1.value : "无");
        System.out.println(ans2 != null ? ans2.value : "无");

        ans1 = midOrDownMidPreNode(test);
        ans2 = right4(test);
        System.out.println(ans1 != null ? ans1.value : "无");
        System.out.println(ans2 != null ? ans2.value : "无");

    }
}
