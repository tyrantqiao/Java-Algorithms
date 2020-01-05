package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tyrantqiao
 * @date 2020/1/6
 * email: tyrantqiao@gmail.com
 */
public class AllArrange {
    public static void permutation(ArrayList result, char array[], int start) {
        if (start == array.length) {
            result.add(new String(array));
        }
        for (int cursor = start; cursor <= array.length - 1; cursor++) {
            if (cursor == start || array[cursor] != array[start]) {
                //在排列的时候进行判断如果后面的元素与start相同时就不进行排序。
                //这样就可以避免对重复元素进行排序
                Swap(array, cursor, start);
                permutation(result, array, start + 1);
                Swap(array, cursor, start);
            }
        }
    }

    public static void Swap(char chs[], int i, int j) {
        char temp;
        temp = chs[i];
        chs[i] = chs[j];
        chs[j] = temp;
    }

    public static void main(String[] args) {
        List result = new ArrayList();
        permutation((ArrayList) result, new char[]{'0', '1', '2'}, 0);
        System.out.println(result);
    }
}
