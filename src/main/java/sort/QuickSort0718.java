package sort;

import java.util.Arrays;

/**
 * QuickSort 20210718 训练$
 * <p>
 * 创建时间： 2021/7/18 17:28
 * 博客地址： <a href="https://tyrantqiao.com">详情戳我(╯‵□′)╯︵┻━┻)</a>
 *
 * @author tyrantqiao
 * @version 1.0
 **/
public class QuickSort0718 {
    public void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public void quickSort(int arr[], int left, int right) {
        if (left >= right || arr == null || arr.length <= 1) {
            return;
        }

        int temp = arr[left];

        int head = left;
        int tail = right;

        while (left <= right) {
            while (arr[left] < temp) {
                left++;
            }

            while (arr[right] > temp) {
                right--;
            }

            if (left < right) {
                swap(arr, left, right);
                // 如果出现了相等的情况，则可以直接往前+1
                // 同时由于我交换了，所以肯定left 比 比较数小，所以left可以直接++， right也可以直接++
                left++;
                right--;
            }

            if (left == right) {
                left++;
            }
        }

        quickSort(arr, head, right);
        quickSort(arr, left, tail);
    }

    public static void main(String[] args) {
        int[] testArr = {30, 15, 40, 2, 10, 9, 7, 8};
        int[] testArr1 = {1};
        new QuickSort0718().quickSort(testArr, 0, testArr.length - 1);
        new QuickSort0718().quickSort(testArr1, 0, testArr.length - 1);
        System.out.println(Arrays.toString(testArr));
        System.out.println(Arrays.toString(testArr1));
    }
}
