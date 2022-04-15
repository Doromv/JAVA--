package class06;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Doromv
 * @create 2022-04-15-14:19
 */
//给你一个链表数组，每个链表都已经按升序排列。
//请你将所有链表合并到一个升序链表中，返回合并后的链表。
//示例 1：
//输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//示例 2：
//输入：lists = []
//输出：[]
//示例 3：
//输入：lists = [[]]
//输出：[]
public class MergeKSortedLists {
    public static class ListNode {
        public int val;
        public ListNode next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) {
            return null;
        }
        PriorityQueue<ListNode> heap=new PriorityQueue<>(new listNodeComparator());
        for (ListNode list : lists) {
            if (list!= null) {
                heap.add(list);
            }
        }
        if (heap.isEmpty()) {
            return null;
        }
        ListNode head=heap.poll();
        ListNode pre=head;
        if(pre.next!=null){
            heap.add(pre.next);
        }
        while (!heap.isEmpty()){
            ListNode cur=heap.poll();
            pre.next=cur;
            pre=cur;
            if(cur.next!=null){
                heap.add(cur.next);
            }
        }
        return head;
    }
    public static class listNodeComparator implements Comparator<ListNode>{

        @Override
        public int compare(ListNode listNode, ListNode t1) {
            return listNode.val-t1.val;
        }
    }
}







