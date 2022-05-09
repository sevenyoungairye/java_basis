package top.lel.lc.easy.merge_two_sorted_lists;

/**
 * @author echo lovely
 * @description 合并两个有序列表为一个有序链表
 * <p>
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * @since 2022/4/11 15:01
 */

public class MergeTwoLists {

    public static void main(String[] args) {

        ListNode listNode = new ListNode(1, new ListNode(5));
        ListNode listNode2 = new ListNode(2, new ListNode(6));

        ListNode res = mergeTwoLists(listNode, listNode2);

        System.out.println(res);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode preHead = new ListNode(0);

        // 第一个节点
        ListNode pre = preHead;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                pre.next = list1;
                list1 = list1.next;
            } else {
                pre.next = list2;
                list2 = list2.next;
            }

            pre = pre.next;
        }

        if (list1 == null) {
            pre.next = list2;
        } else {
            pre.next = list1;
        }

        return preHead.next;
    }


    /**
     * Definition for singly-linked list.
     */
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

}

