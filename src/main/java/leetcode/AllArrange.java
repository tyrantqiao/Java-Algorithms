package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tyrantqiao
 * @date 2020/1/6
 * email tyrantqiao@gmail.com
 */
public class AllArrange {
    /**
     * 理解为三个人ABC拍照
     * ABC 拍照
     * B和C 换位
     * ACB 拍照
     * B和C 换位
     * ABC
     * A和C 换位
     * CBA 拍照
     * B和A 换位
     * CAB 拍照
     * AB  换位
     * CBA
     * C和A 换位
     * ABC
     *
     * @param result 结果列表
     * @param array  数组
     * @param start  开始位置
     */
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
