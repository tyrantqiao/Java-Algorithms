package leetcode;

import java.util.Arrays;

/**
 * 566重塑矩阵$
 * <p>
 * 创建时间：  2021/2/18 22:54
 * 博客地址为： <a href="https://tyrantqiao.com">详情戳我(╯‵□′)╯︵┻━┻</a>
 *
 * @author tyrantqiao
 * @version 1.0
 **/
public class ReshapeMatrix {
    /**
     * 暴力，通过设置两个标志位实现这个解法
     *
     * @param nums   数组
     * @param row    改变的行
     * @param column 改变的列
     * @return 结果
     */
    public static int[][] matrixReshape(int[][] nums, int row, int column) {
        if (nums == null) {
            return null;
        }

        int originRows = nums.length;
        int originColumns = nums[0].length;
        int matrixElements = originRows * originColumns;
        int transferElements = row * column;
        if (matrixElements != transferElements) {
            return nums;
        }

        int[][] resultMatrix = new int[row][column];
        int transferX = 0;
        int transferY = 0;
        for (int[] num : nums) {
            for (int j = 0; j < originColumns; j++) {
                if (transferY == column) {
                    transferY = 0;
                    transferX++;
                }
                if (transferX == row) {
                    break;
                }
                resultMatrix[transferX][transferY] = num[j];
                transferY++;
            }
        }

        return resultMatrix;
    }

    /**
     * 数学解法
     * <p>
     * 首先矩阵无非是   行=总数➗列数， 列=总数%列数，套这两个公式进行切换即可
     *
     * @param nums   数组
     * @param row    改变的行
     * @param column 改变的列
     * @return 结果
     */
    public static int[][] matrixReshapeBetter(int[][] nums, int row, int column) {
        if (nums == null) {
            return null;
        }

        int originRows = nums.length;
        int originColumns = nums[0].length;
        int matrixElements = originRows * originColumns;
        int transferElements = row * column;
        if (matrixElements != transferElements) {
            return nums;
        }

        int[][] resultMatrix = new int[row][column];
        for (int i = 0; i < matrixElements; i++) {
            resultMatrix[i / column][i % column] = nums[i / originColumns][i % originColumns];
        }

        return resultMatrix;
    }

    public static void main(String[] args) {
        int[][] testMatrix = new int[1][2];
        testMatrix[0][0] = 1;
        testMatrix[0][1] = 2;

        System.out.println(Arrays.deepToString(matrixReshape(testMatrix, 2, 1)));
        System.out.println(Arrays.deepToString(matrixReshapeBetter(testMatrix, 2, 1)));
    }
}
