package leetcode;

import java.util.Arrays;

/**
 * @author tyrantqiao
 * date: 2019/5/23
 * blog: tyrantqiao.com
 * contact: tyrantqiao@icloud.com
 */
public class ArrayProblems {
    /**
     * 镜像以及反转数值，通过设置中值，(cols+1)/2，然后通过左右与这个中值进行比较，慢慢进行反转以及镜像
     *
     * @param A
     * @return
     */
    public int[][] flipAndInvertImage(int[][] A) {
        int cols = A.length;
        for (int[] row : A) {
            for (int col = 0; col < (cols + 1) / 2; col++) {
                int temp = row[col] ^ 1;
                row[col] = row[cols - 1 - col] ^ 1;
                row[cols - 1 - col] = temp;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        ArrayProblems arrayProblems = new ArrayProblems();
        System.out.println(Arrays.deepToString(arrayProblems.flipAndInvertImage(new int[][]{{1, 0}, {0, 1}})));
    }
}
