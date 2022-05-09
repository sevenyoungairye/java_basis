package top.lel.lc.easy.rm_dup_from_sorted_list;

/**
 * @author echo lovely
 * @date 2022/5/5 11:36
 * @description 移除重复的元素
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 */

public class RmDupFromSortedList {

    public static void main(String[] args) {
        ListNode res = deleteDuplicates(new ListNode(0, new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(3))))));

        System.out.println("==========");
        forEach(res);

        System.out.println("upgrade...");
        ListNode upgrade = upgrade(new ListNode(0, new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(3))))));
        System.out.println("====");
        forEach(upgrade);
    }

    public static ListNode upgrade(ListNode head) {
        ListNode cur = head;
        while(cur != null && cur.next != null) {
            if(cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode resNode = new ListNode();

        ListNode node = head;

        while (node != null) {

            if (node.next != null && node.next.val == node.val) {
                System.out.println("哒咩: " + node.val);
            } else {
                // 添加到链表...
                ListNode headNode = resNode;
                while (headNode.next != null) {
                    headNode = headNode.next;
                }
                headNode.next = new ListNode(node.val);
            }
            node = node.next;
        }

        return resNode.next;
    }

    public static void forEach(ListNode head) {
        while (head != null) {
            int currentVal = head.val;
            System.out.println(currentVal);
            head = head.next;
        }
    }

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
    }
}
