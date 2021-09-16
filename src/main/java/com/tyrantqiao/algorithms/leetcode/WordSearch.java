package com.tyrantqiao.algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: search char[][] whether there are some words we want
 * answer by yavinci
 * 核心是我们维护一个字母表形式的链表(TridNode)，用来存放单词（对HashSet的优化）
 * 然后我们开始迭代每一个元素，对首元素含单词的进行递归
 * <p>
 * 递归的核心：我们先判断是否需要向上，避免多次的if判断，因为我们是从左上角开始的。
 * 紧接着用深度优先搜索(DFS)开始查询，若检索的字母表链表中的某个元素中含有单词，添加，并且将其游离掉，避免重复(null)
 * <a href="https://leetcode.com/problems/word-search-ii/description/"></a>
 *
 * @author tyrantqiao [tyrantqiao@gmail.com]
 * @see <a href="https://github.com/tyrantqiao">qiao's github</a>
 */
public class WordSearch {
	public static List<String> findWords(char[][] board, String[] words) {
		TridNode root = buildTridNode(words);
		List<String> result = new ArrayList<>();
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[0].length; col++) {
				dfs(board, row, col, root, result);
			}
		}
		return result;
	}

	private static void dfs(char[][] board, int row, int col, TridNode node, List<String> result) {
		char currentChar = board[row][col];
		char isVisited = '#';
		char aChar = 'a';
//		int nextChar = currentChar - aChar;
		if (currentChar == isVisited || node.next[currentChar - aChar] == null) {
			return;
		}
		node = node.next[currentChar - aChar];
		if (node.word != null) {
			result.add(node.word);
			node.word = null;
		}
		board[row][col] = isVisited;
		if (row > 0) {
			dfs(board, row - 1, col, node, result);
		}
		if (col > 0) {
			dfs(board, row, col - 1, node, result);
		}
		if (row < board.length - 1) {
			dfs(board, row + 1, col, node, result);
		}
		if (col < board[0].length - 1) {
			dfs(board, row, col + 1, node, result);
		}
		board[row][col] = currentChar;
	}

	private static TridNode buildTridNode(String[] words) {
		TridNode root = new TridNode();
		for (String word : words) {
			TridNode node = root;
			for (char c : word.toCharArray()) {
				int i = c - 'a';
				if (node.next[i] == null) {
					node.next[i] = new TridNode();
				}
				node = node.next[i];
			}
			node.word = word;
		}
		return root;
	}

	private static class TridNode {
		TridNode[] next = new TridNode[26];
		String word;
	}
}
