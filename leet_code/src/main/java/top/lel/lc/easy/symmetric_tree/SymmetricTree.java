package top.lel.lc.easy.symmetric_tree;

import top.lel.lc.base.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author echo lovely
 * @date 2022/5/7 13:46
 * @description 对称二叉树
 * https://leetcode-cn.com/problems/symmetric-tree/
 */

public class SymmetricTree {

    public static void main(String[] args) {

        boolean symmetric = isSymmetric(new TreeNode(99,
                        new TreeNode(1, new TreeNode(2), new TreeNode(3)),
                        new TreeNode(1, new TreeNode(3), new TreeNode(2))
                )
        );

        System.out.println(symmetric);

    }

    public static boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return false;
        }

        return forEach(root, root);
    }

    public static boolean forEach(TreeNode node0, TreeNode node1) {
        if (node0 == null && node1 == null) {
            return true;
        }

        if (node0 == null || node1 == null) {
            return false;
        }

        return node0.val == node1.val && forEach(node0.left, node1.right) && forEach(node0.right, node1.left);
    }

    public static boolean useQueue(TreeNode node0, TreeNode node1) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node0);
        queue.offer(node1);

        while (!queue.isEmpty()) {
            TreeNode n1 = queue.poll();
            TreeNode n2 = queue.poll();

            // 左子树搜索完 再搜索右子树
            if (n1 == null && n2 == null) {
                continue;
            }

            if (n1 == null || n2 == null) {
                return false;
            }

            if (n1.val != n2.val) {
                return false;
            }

            queue.offer(n1.left);
            queue.offer(n2.right);

            queue.offer(n1.right);
            queue.offer(n2.left);
        }


        return true;
    }


}
