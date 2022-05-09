package top.lel.lc.base.tree;

/**
 * @author echo lovely
 * @date 2022/5/7 14:56
 * @description 二叉树结构
 */

public class TreeNode {

    public int val;

    public TreeNode left;

    public TreeNode right;

    public TreeNode() {}

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
