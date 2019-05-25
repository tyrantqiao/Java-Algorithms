package leetcode;

/**
 * @author tyrantqiao
 * date: 2018/10/29
 * blog: tyrantqiao.com
 * contact: tyrantqiao@gmail.com
 */
public class RemoveElement {
    /**
     * 因为只要去掉value后的数组，所以其实不用考虑像要把相等的数字置于后面的想法，直接把所有
     * 不相等的value在前面好好排着就可以了O(n)+O(1)的空间
     * <p>
     * 如果需要置后，在加个尾指针存放也可以。
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }

        int notEqualIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[notEqualIndex] = nums[i];
                notEqualIndex++;
            }
        }
        return notEqualIndex;
    }

    public static void main(String[] args) {
        RemoveElement removeElement = new RemoveElement();
        System.out.println(removeElement.removeElement(new int[]{1, 2, 4, 5, 2, 2, 2, 3}, 2));
    }
}
