package sort;

import java.util.Arrays;

/**
 * quicksort 的测试类$
 * <p>
 * 创建时间： 2021/7/19 6:58
 * 博客地址： <a href="https://tyrantqiao.com">详情戳我(╯‵□′)╯︵┻━┻)</a>
 *
 * @author tyrantqiao
 * @version 1.0
 **/
public class QuickSort {

    public static void main(String[] args) {
        int[] testArr = {30, 15, 40, 2, 9, 10, 9, 7, 8};
        int[] testArr1 = {1};
        new QuickSort0719().quickSort(testArr, 0, testArr.length - 1);
        new QuickSort0719().quickSort(testArr1, 0, testArr.length - 1);
        System.out.println(Arrays.toString(testArr));
        System.out.println(Arrays.toString(testArr1));
    }
}
