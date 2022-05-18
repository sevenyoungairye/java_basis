package top.lel.lc.base.linked_list;

import java.util.function.Consumer;

/**
 * @author echo lovely
 * @date 2022/5/16 10:14
 * @description linked list ds
 */

public class ListNode {

    public int val;

    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    /**
     * [1, 2, 3], 链表toString重写.
     */
    public String toString() {
        ListNode head = this;

        StringBuilder builder = new StringBuilder("[");
        while (head != null) {
            if (head.next == null) {
                builder.append(head.val).append("]");
            } else {
                builder.append(head.val).append(", ");
            }
            head = head.next;
        }
        return builder.toString();
    }

    /**
     * 迭代
     *
     * @param action 迭代链表操作, action操作值
     */
    public void forEach(Consumer<? super ListNode> action) {
        ListNode head = this;

        while (head != null) {
            action.accept(head);
            head = head.next;
        }
    }


}
