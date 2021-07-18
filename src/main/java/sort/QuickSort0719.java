package sort;

/**
 * QuickSort0719$
 * <p>
 * 创建时间： 2021/7/19 6:53
 * 博客地址： <a href="https://tyrantqiao.com">详情戳我(╯‵□′)╯︵┻━┻)</a>
 *
 * @author tyrantqiao
 * @version 1.0
 **/
public class QuickSort0719 {
    public void swap(int arr[], int left, int right) {
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

}
