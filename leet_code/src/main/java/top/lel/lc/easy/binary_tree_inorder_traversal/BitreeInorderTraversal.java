package top.lel.lc.easy.binary_tree_inorder_traversal;

import top.lel.lc.base.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author echo lovely
 * @date 2022/5/6 15:03
 * @description https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */

public class BitreeInorderTraversal {


    public static void main(String[] args) {

        // 中序遍历顺序：左子树 根节点 右子树
        // [1, 0, 3, 2, 4]
        TreeNode treeNode = new TreeNode(0, new TreeNode(1), new TreeNode(2, new TreeNode(3), new TreeNode(4)));

        List<Integer> res = inorderTraversal(treeNode);
        System.out.println(res);

    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        forEach(list, root);

        return list;
    }

    private static void forEach(List<Integer> list, TreeNode treeNode) {

        if (treeNode == null) {
            return;
        }

        if (treeNode.left != null) {
            forEach(list, treeNode.left);
        }
        list.add(treeNode.val);
        if (treeNode.right != null) {
            forEach(list, treeNode.right);
        }
    }

}
