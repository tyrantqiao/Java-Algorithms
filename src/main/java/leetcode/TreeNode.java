package leetcode;

import java.util.List;

/**
 * @author tyrantqiao
 * treeNode节点，大部分时候用作leetcode的链表树的实现
 * 现加入如何打印树的功能
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    private List<TreeNode> children;

    TreeNode(int x) {
        val = x;
    }

    public TreeNode() {
    }

    public TreeNode(int val, List<TreeNode> children) {
        this.val = val;
        this.children = children;
    }

    /**
     * from Todd Davies ~ stackoverflow
     * 首先调用这个函数，起码有个根或者没根，就会有个|   的符号，然后判断有没有右子树
     * 如果有，那么它就会在|   |-- 右子树这边
     * 当右子树走完了，添加中间结点
     * |    |--
     * |__  xxxx
     * 最后就是添加左子树了用空格和|分开即可
     * │   ┌── 3
     * └── 2
     *     └── 1
     *         └── 0
     *
     * @param prefix
     * @param isTail
     * @param sb
     * @return
     */
    public StringBuilder toString(StringBuilder prefix, boolean isTail, StringBuilder sb) {
        if (right != null) {
            right.toString(new StringBuilder().append(prefix).append(isTail ? "│   " : "    "), false, sb);
        }
        sb.append(prefix).append(isTail ? "└── " : "┌── ").append(val).append("\n");
        if (left != null) {
            left.toString(new StringBuilder().append(prefix).append(isTail ? "    " : "│   "), true, sb);
        }
        return sb;
    }

    @Override
    public String toString() {
        return this.toString(new StringBuilder(), true, new StringBuilder()).toString();
    }
}
