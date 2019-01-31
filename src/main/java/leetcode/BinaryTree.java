package leetcode;

import org.antlr.runtime.tree.Tree;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/"></a>
 * 先从左到右，再右到左，反复添加。
 *
 * @author tyrantqiao [tyrantqiao@gmail.com]
 * @see <a href="https://github.com/tyrantqiao">qiao's github</a>
 */
public class BinaryTree {
    /**
     * 一层一层地对root的左右节点进行迭代判断，小于左则用右边的
     *
     * @param root
     * @param L
     * @param R
     * @return
     */
    private TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) {
            return root;
        }
        if (root.val < L) {
            return trimBST(root.right, L, R);
        } else if (root.val > R) {
            return trimBST(root.left, L, R);
        }

        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
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

    /**
     * 另外一个做法维护一个map表，对每一个节点进行一个存储当前高度，迭代时+1，通过比较各自的depth返回结果
     * 而这个做法是递归循环到底部，出来时+1并对左和右进行一个比较。
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMaxDepth = maxDepth(root.left);
        int rightMaxDepth = maxDepth(root.right);
        return Math.max(leftMaxDepth, rightMaxDepth) + 1;
    }

    /**
     * 调用递归方法获取结果
     *
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }

        TreeNode tree = tranArrayToBST(nums, 0, nums.length - 1);
        return tree;
    }

    /**
     * 每次以mid为根节点，然后分为左右两半，当到边界时返回null，否则作为左右枝节点
     *
     * @param sortedNums
     * @param left
     * @param right
     * @return
     */
    private TreeNode tranArrayToBST(int[] sortedNums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode bst = new TreeNode(sortedNums[mid]);
        bst.left = tranArrayToBST(sortedNums, left, mid - 1);
        bst.right = tranArrayToBST(sortedNums, mid + 1, right);
        return bst;
    }


    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.right.left = new TreeNode(4);
        System.out.println(binaryTree.maxDepth(treeNode));
    }
}
