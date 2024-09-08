package class018非递归遍历二叉树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Test {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

    // 前序遍历
    public static List<Integer> preOrder(TreeNode root) {
        List<Integer> list = new ArrayList<>(); // 用于存储前序遍历结果
        Stack<TreeNode> stack = new Stack<>(); // 辅助栈，用于遍历树
        TreeNode cur = root; // 当前节点初始化为根节点
        while (cur != null || !stack.isEmpty()) { // 当当前节点不为空或栈不为空时继续遍历
            while (cur != null) { // 一直往左子树遍历
                list.add(cur.val); // 访问当前节点
                stack.push(cur); // 当前节点入栈
                cur = cur.left; // 移动到左子节点
            }
            cur = stack.pop(); // 弹出栈顶节点
            cur = cur.right; // 移动到右子节点
        }
        return list;
    }

    // 中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>(); // 用于存储中序遍历结果
        Stack<TreeNode> stack = new Stack<>(); // 辅助栈，用于遍历树
        TreeNode cur = root; // 当前节点初始化为根节点
        while (cur != null || !stack.isEmpty()) { // 当当前节点不为空或栈不为空时继续遍历
            while (cur != null) { // 一直往左子树遍历
                stack.push(cur); // 当前节点入栈
                cur = cur.left; // 移动到左子节点
            }
            cur = stack.pop(); // 弹出栈顶节点
            list.add(cur.val); // 访问当前节点
            cur = cur.right; // 移动到右子节点
        }
        return list;
    }

    // 后序遍历，非递归
    public static List<Integer> postOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>(); // 辅助栈，用于遍历树
        List<Integer> list = new ArrayList<>(); // 用于存储后序遍历结果
        TreeNode cur = root; // 当前节点初始化为根节点
        TreeNode p = null; // 用于记录上一个节点
        while (!stack.isEmpty() || cur != null) { // 当当前节点不为空或栈不为空时继续遍历
            while (cur != null) { // 一直往左子树遍历
                stack.push(cur); // 当前节点入栈
                cur = cur.left; // 移动到左子节点
            }
            cur = stack.peek(); // 查看栈顶节点但不弹出
            // 如果右子节点为空或右子节点已被访问，则访问当前节点
            if (cur.right == null || cur.right == p) {
                list.add(cur.val); // 访问当前节点
                stack.pop(); // 弹出栈顶节点
                p = cur; // 更新上一节点为当前节点
                cur = null; // 设置当前节点为空
            } else {
                cur = cur.right; // 移动到右子节点
            }
        }
        return list;
    }
}
