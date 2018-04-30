package leetcode;

import java.util.HashSet;
import java.util.Set;
/**
 * @author tyrantqiao
 */
public class ValidSquare {
    public static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Set distanceSet=new HashSet();
        distanceSet.add(getDistance(p1,p2));
        distanceSet.add(getDistance(p1,p3));
        distanceSet.add(getDistance(p1,p4));
        distanceSet.add(getDistance(p4,p2));
        distanceSet.add(getDistance(p4,p3));
        distanceSet.add(getDistance(p2,p3));
        System.out.println(distanceSet);
        return !distanceSet.contains(0)&&distanceSet.size()==2;

    }

    private static int getDistance(int[]left,int[] right) {
        return (left[0]-right[0])*(left[0]-right[0])+(left[1]-right[1])*(left[1]-right[1]);
    }

    public static void main(String[] args) {
        int[] a = {1, -1};
        int[] b = {1, 1};
        int[] c = {0, 1};
        int[] d = {0, 0};
        boolean result = validSquare(a, b, c, d);
        System.out.println(result);
    }
}
