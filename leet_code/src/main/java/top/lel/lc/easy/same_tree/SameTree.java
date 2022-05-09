package top.lel.lc.easy.same_tree;

import top.lel.lc.base.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author echo lovely
 * @date 2022/5/6 17:20
 * @description 相同的树
 * https://leetcode-cn.com/problems/same-tree/
 * 1. 深度优先：递归
 * 2. 广度优先：使用队列
 */

public class SameTree {

    public static void main(String[] args) {

        /*boolean sameTree = isSameTree(new TreeNode(0, new TreeNode(), new TreeNode()), new TreeNode());
        System.out.println(sameTree);*/

        System.out.println(1 ^ 2);
        System.out.println(3 ^ 8 ^ 12);

        // 相同取0，相异取1
        /*System.out.println(true ^ false);
        System.out.println(false ^ true);
        System.out.println(true ^ true);
        System.out.println(false ^ false);*/

        boolean b = deepWay(new TreeNode(9, new TreeNode(0), new TreeNode(1)), new TreeNode(9, new TreeNode(0), new TreeNode(1)));
        System.out.println(b);
    }

    private static boolean deepWay(TreeNode p, TreeNode q) {

        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        Queue<TreeNode> queue1 = new LinkedList<>();
        queue1.offer(p);

        Queue<TreeNode> queue2 = new LinkedList<>();
        queue2.offer(q);

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode treeNode1 = queue1.poll();
            TreeNode treeNode2 = queue2.poll();

            if (treeNode2 == null || (treeNode1.val != treeNode2.val)) {
                return false;
            }

            TreeNode left1 = treeNode1.left, left2 = treeNode2.left, right1 = treeNode1.right, right2 = treeNode2.right;

            // 异或：如果全部是空，判断是false, 全部不是空, 判断也是false. 则跳过if语句
            // 如果一个空，一个非空，return false
            if (left1 == null ^ left2 == null) {
                return false;
            }

            if (right1 == null ^ right2 == null) {
                return false;
            }

            if (left1 != null) {
                queue1.offer(left1);
            }

            if (left2 != null) {
                queue2.offer(left2);
            }

            if (right1 != null) {
                queue1.offer(right1);
            }

            if (right2 != null) {
                queue2.offer(right2);
            }
        }

        return queue1.isEmpty() && queue2.isEmpty();
    }

    private static boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) {
            return true;
        }

        if (p != null && q != null && p.val == q.val) {

            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }

        return false;
    }


}
