package leetcode;

public class ValidSquare {
    public static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        return testPoint(p1, p2, p3, p4);
    }

    private static boolean testPoint(int[]... points) {
        int size = points.length;
        int tag = 0;
        int diagonal = -1;
        for (int i = 1; i < size; i++) {
            if (points[0][0] == points[i][0] || points[0][1] == points[i][1]) tag++;
            else {
                diagonal = i;
            }
        }
        if (tag != 2) return false;
        int index = 1;
        tag = 0;
        for (int i = 1; i < 3; i++) {
            if (index == diagonal) index++;
            if (points[diagonal][0] == points[index][0] || points[diagonal][1] == points[index][1]) tag++;
        }
        return tag == 2;
    }

    public static void main(String[] args) {
        int[] a = {1, 1};
        int[] b = {1, 1};
        int[] c = {0, 1};
        int[] d = {0, 0};
        boolean result = validSquare(a, b, c, d);
        System.out.println(result);
    }
}
