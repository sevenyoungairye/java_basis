package top.lel.lc.easy.binary_tree_max_depth;

import top.lel.lc.base.tree.TreeNode;


/**
 * @author echo lovely
 * @date 2022/5/7 14:58
 * @description 二叉树的最大深度
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 */

public class MaxDepthOfBinaryTree {

    public static void main(String[] args) {

    }

    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }


        return getMaxDepth( root);
    }

    public int getMaxDepth(TreeNode node0) {

        if (node0 == null) {
            return 0;
        } else {
            int leftDepth = getMaxDepth(node0.left);
            int rightDepth = getMaxDepth(node0.right);
            System.out.println(leftDepth + "\t" + rightDepth);
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }

}
