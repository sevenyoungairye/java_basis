package top.lel.lc.easy.link_recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jz_lee
 * @date 2021/9/13 17:38
 * @description 两数相加..
 *
 */

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3)));


        ListNode preNode = null;

        // case1
        while (node != null) {
            ListNode next = node.next;

            // 保存preNode的前一个节点...
            node.next = preNode;
            preNode = node;

            // 切换到下一个节点
            node = next;
        }

        // case2
        /*for (ListNode head = node; head != null; head = head.next) {
            System.out.println(head.val);
            preNode = new ListNode(head.val, preNode);
        }*/

        while (preNode != null) {
            System.out.println(preNode.val);
            preNode = preNode.next;
        }

    }
}

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    List<Integer> list = new ArrayList<>();

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode first = null;
        ListNode second = null;

        // 1. l1, l2, 倒过来..
        while (l1.next != null) {
            list.add(l1.next.val);
        }
        // 2. 求和..
        // 3. 将结果倒过来...
        return null;
    }

}
