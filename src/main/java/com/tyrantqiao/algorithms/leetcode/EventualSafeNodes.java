package com.tyrantqiao.algorithms.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author tyrant
 */
public class EventualSafeNodes {
    /**
     * 设置深度优先查询表，每一个查询时根据查询结果来决定这个数是不是安全的【无边的】
     *
     * @param graph
     * @return
     */
    public static List<Integer> eventualSafeNodes(int[][] graph) {
        int size = graph.length;
        int[] dfsResult = new int[size];
        List<Integer> results = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            if (dfs(i, graph, dfsResult)) {
                results.add(i);
            }
        }
        return results;
    }

    /**
     * 设置深度优先有三种结果，0-未处理，1-无环，2-有环
     * 首先是判断处理过没有，若处理过则肯定大于0，那么就可以判断它是不是为无环的。
     * 再对表每个数的points遍历时，若深度查询表发现这个point是有环的【2】，则返回false
     * 这里有个点是若判断==2，减少递归次数，若不判断==2，那么判断次数就减少很多，当遍历一直无环时就很麻烦了。
     *
     * @param i
     * @param graph
     * @param dfsResult
     * @return
     */
    private static boolean dfs(int i, int[][] graph, int[] dfsResult) {
        if (dfsResult[i] > 0) {
            return dfsResult[i] == 1;
        }

        dfsResult[i] = 2;
        for (int point : graph[i]) {
            if (dfsResult[point] == 2 || !dfs(point, graph, dfsResult)) {
                return false;
            }
        }

        dfsResult[i] = 1;
        return true;
    }
}
