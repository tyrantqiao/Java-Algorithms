package dynamic.programming;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Stair combination$
 * <p>
 * 创建时间： 2021/7/26 22:27
 * 博客地址： <a href="https://tyrantqiao.com">详情戳我(╯‵□′)╯︵┻━┻)</a>
 *
 * @author tyrantqiao
 * @version 1.0
 **/
public class StairCombination {
    /**
     * 阶梯组合
     *
     * @param allCombinationSize 一共有多少组合
     * @param canUseStairList    可以使用的阶梯列表
     * @param needToReachStair   需要到达的阶梯
     * @return 阶梯组合
     */
    public int stairCombination(AtomicInteger allCombinationSize, List<Integer> canUseStairList, int needToReachStair) {
        if (needToReachStair == 0) {
            allCombinationSize.incrementAndGet();
            return 0;
        }

        if (needToReachStair < 0) {
            return -1;
        }

        int result = Integer.MAX_VALUE;
        for (int canUseStair : canUseStairList) {
            int eachResult = stairCombination(allCombinationSize, canUseStairList, needToReachStair - canUseStair);
            if (eachResult == -1) {
                continue;
            }

            result = Math.min(result, eachResult + 1);
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public static void main(String[] args) {
        AtomicInteger allCombinationSize = new AtomicInteger(0);
        System.out.println(new StairCombination().stairCombination(allCombinationSize, Arrays.asList(1, 2), 9));
        System.out.println("all: " + allCombinationSize);
    }
}
