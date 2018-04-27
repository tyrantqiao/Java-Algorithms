package leetcode;

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class DuplicateSubtrees {

	/***
     *  通过递归来获得最终答案.
	 * @param root
	 * @return result
	 */
	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		List<TreeNode> result=new ArrayList<>();
		HashMap<String,Integer> map=new HashMap<String,Integer>();
		postTreeNode(root,map,result);
		return result;
	}
	/*  version one from discuss.
	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		List<TreeNode> result=new LinkedList<>();
		postTreeNode(root,new HashMap(),result);
		return result;
	}
     */
	/**
	 * 核心在于生成每一条支树的序列号,而这个东西只需要最基本的数据即可,其他的东西都可以不加(耗时,但为了美化时可加)
	 * 然后在存储时,把值设为1,1才是判断的基本,因为这是第一次,而在下一次的遍历时也可能重复了,所以要进行判断,避免重复了.
	 * @param root 节点
	 * @param map 用于存放每一节的东西
	 * @param result 结果
	 * @return 每一次的值
	 */
	public String postTreeNode(TreeNode root, Map<String,Integer> map,List<TreeNode> result){
		if(root==null)return "$";
		String serial=root.val+postTreeNode(root.left,map,result)+postTreeNode(root.right,map,result);
        /*
        if(map.containsKey(serial)&&map.get(serial)==1)result.add(root);
        map.put(serial,map.getOrDefault(serial,0)+1);
        */
		if(!map.containsKey(serial)){
			map.put(serial,1);
		}
		else{
			if(map.get(serial)<2){
				map.put(serial,2);
				result.add(root);
			}
		}
		return serial;
	}
	/*
	public String postTreeNode(TreeNode root, Map<String,Integer> map, List<TreeNode> result){
		if(root==null)return "$";
		String serial="val"+root.val+"---"+"left:"+postTreeNode(root.left,map,result)+"right:"+postTreeNode(root.right,map,result);
		if(map.getOrDefault(serial,0)==1)result.add(root);
		map.put(serial,map.getOrDefault(serial,0)+1);
		return serial;
	}
	*/
}
