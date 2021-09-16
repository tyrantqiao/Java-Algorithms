package com.tyrantqiao.algorithms.leetcode;

/**
 * @author tyrantqiao
 * date: 2019/5/28
 * blog: tyrantqiao.com
 * contact: tyrantqiao@gmail.com
 */
public class PointProblems {
    /**
     * 将所有走一遍，然后把xy轴数据看看是不是0就知道结果了
     *
     * @param moves
     * @return
     */
    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        for (char c : moves.toCharArray()) {
            switch (c) {
                case 'L': {
                    x--;
                    break;
                }
                case 'R': {
                    x++;
                    break;
                }
                case 'U': {
                    y++;
                    break;
                }
                case 'D': {
                    y--;
                    break;
                }
                default: {
                    break;
                }
            }
        }
        return x == 0 && y == 0;
    }
}
