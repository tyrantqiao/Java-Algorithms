package dynamic.programming;

import java.util.Arrays;

/**
 * Fibonacci 斐波那契数列问题$
 * <p>
 * 创建时间： 2021/7/25 20:46
 * 博客地址： <a href="https://tyrantqiao.com">详情戳我(╯‵□′)╯︵┻━┻)</a>
 * <p>
 * 问题：斐波那契数列黄金分割数列，1，1，2，3，5   之后的数是由前两数的累加而成
 *
 * @author tyrantqiao
 * @version 1.0
 **/
public class Fibonacci {
    /**
     * 暴力穷举
     * <p>
     * 问题： 比如说3，会在fib(5)计算一次，然后又在fib(4)中又算了一次，就造成了浪费
     *
     * @param whichNumber 第几位数
     * @return 第几位数的值是啥
     */
    public int fib(int whichNumber) {
        if (whichNumber == 1 || whichNumber == 2) {
            return 1;
        }
        return fib(whichNumber - 1) + fib(whichNumber - 2);
    }

    /**
     * fib 备忘录版本，记录算过的值
     *
     * @param whichNumber 哪个数字
     * @return 数字对应的值
     */
    public int fibMemorandum(int whichNumber) {
        if (whichNumber <= 1) {
            return 1;
        }

        int[] memorandumArray = new int[whichNumber + 1];
        Arrays.fill(memorandumArray, 0);
        return memorandumCalculate(memorandumArray, whichNumber);
    }

    /**
     * 计算
     * <p>
     * 其实就是拿个数组记录下，也没有什么很突出的地方，这里数组记下，偷懒没有按照0开始操作的，所以数组记得多加一位定义
     *
     * @param memorandumArray 备忘录数组
     * @param whichNumber     第几位数
     * @return 返回结果
     */
    private int memorandumCalculate(int[] memorandumArray, int whichNumber) {
        if (whichNumber == 1 || whichNumber == 2) {
            return 1;
        }

        if (memorandumArray[whichNumber] != 0) {
            return memorandumArray[whichNumber];
        }

        return memorandumArray[whichNumber] =
                memorandumCalculate(memorandumArray, whichNumber - 1)
                        + memorandumCalculate(memorandumArray, whichNumber - 2);
    }

    public static void main(String[] args) {
        System.out.println(new Fibonacci().fib(5));
        System.out.println(new Fibonacci().fibMemorandum(5));
    }
}
