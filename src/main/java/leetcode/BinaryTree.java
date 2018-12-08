package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/"></a>
 * 先从左到右，再右到左，反复添加。
 *
 * @author tyrantqiao [tyrantqiao@gmail.com]
 * @see <a href="https://github.com/tyrantqiao">qiao's github</a>
 */
public class BinaryTree {
    /**
     * 一层一层地对root的左右节点进行迭代判断
     *
     * @param root
     * @param L
     * @param R
     * @return
     */
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root==null) {
            return root;
        }
        if(root.val<L) {
            return trimBST(root.right,L,R);
        }else if(root.val>R){
            return trimBST(root.left,L,R);
        }

        root.left=trimBST(root.left,L,R);
        root.right=trimBST(root.right,L,R);
        return root;
    }

    /**
     * 调用递归函数，返回结果
     *
     * @param root 根节点
     * @return result
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        travel(root, res, 0);
        return res;
    }

    /**
     * 用递归的形式求解，当前节点为null时返回【基本判断】
     * 引入level的形式，当res的数量<=level时就可以创建新的list来装载这个等级下的玩意
     * 以DFS的形式对左边搜完，每往下搜一层，level就+1，当检索完左边时从travel(left,res,level+1)中
     * 退出来，而刚加的level就会退回来，开始执行travel(right,res,level+1)对右支树开始遍历
     * 然后因为有左右支树，通过level的形式判断是否能作为当前list的根节点
     *
     * @param node
     * @param res
     * @param level
     */
    private void travel(TreeNode node, List<List<Integer>> res, int level) {
        if (node == null) {
            return;
        }

        if (res.size() <= level) {
            List<Integer> newLevel = new LinkedList<>();
            res.add(newLevel);
        }

        List<Integer> collection = res.get(level);
        if (level % 2 == 0) {
            collection.add(node.val);
        } else {
            collection.add(0, node.val);
        }

        travel(node.left, res, level + 1);
        travel(node.right, res, level + 1);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        getNodeByInorderIterative(root, result);
        return result;
    }

    /**
     * use stack to save the last element, and then pop, we save left element first, the latest left element will
     * pop first, then is the mid element, we would put the right element by {@code node=node.right}
     *
     * @param node
     * @param res
     */
    private void getNodeByInorderIterative(TreeNode node, List<Integer> res) {
        Stack<TreeNode> treeNodeStack = new Stack<>();
        do {
            while (node != null) {
                treeNodeStack.push(node);
                node = node.left;
            }
            if (!treeNodeStack.isEmpty()) {
                node = treeNodeStack.pop();
                res.add(node.val);
                node = node.right;
            }
        } while (!treeNodeStack.isEmpty() || node != null);
    }

    /**
     * 递归，直接递归左节点，添加节点，然后递归右节点，添加节点。
     *
     * @param node
     * @param res
     */
    private void getNodeByInorderRecursive(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        getNodeByInorderRecursive(node.left, res);
        res.add(node.val);
        getNodeByInorderIterative(node.right, res);
    }
}
