package dynamic.programming;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;

/**
 * 找到小费的最优组成形式$
 * <p>
 * 创建时间： 2021/7/26 6:35
 * 博客地址： <a href="https://tyrantqiao.com">详情戳我(╯‵□′)╯︵┻━┻)</a>
 *
 * @author tyrantqiao
 * @version 1.0
 **/
public class CoinTip {
    /**
     * 暴力解法，本质在于不断求解子方程，并利用当等于0时，返回1，假如扣成负数，那就返回-1
     *
     *
     * @param canUseCoinList   可以使用的硬币列表
     * @param needToCombineTip 需要凑成的小费
     * @return 最小数量是什么
     */
    public int findMinCoinTipCombination(List<Integer> canUseCoinList, int needToCombineTip) {
        if (needToCombineTip == 0) {
            return 0;
        }
        if (needToCombineTip < 0) {
            return -1;
        }

        int result = Integer.MAX_VALUE;
        for (int eachCombinationCoin : canUseCoinList) {
            int eachResult = findMinCoinTipCombination(canUseCoinList, needToCombineTip - eachCombinationCoin);
            if (eachResult == -1) {
                continue;
            }
            result = Math.min(result, 1 + eachResult);
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    /**
     * 备忘录方法，本质在于不断求解子方程，并利用当等于0时，返回1，假如扣成负数，那就返回-1
     * TBD 待完成
     *
     * @param canUseCoinList   可以使用的硬币列表
     * @param needToCombineTip 需要凑成的小费
     * @return 最小数量是什么
     */
    public int findMinCoinTipCombinationMemorandum(List<Integer> canUseCoinList, int needToCombineTip) {
        if (needToCombineTip == 0) {
            return 0;
        }
        if (needToCombineTip < 0) {
            return -1;
        }

        int result = Integer.MAX_VALUE;
        for (int eachCombinationCoin : canUseCoinList) {
            int eachResult = findMinCoinTipCombinationMemorandum(canUseCoinList, needToCombineTip - eachCombinationCoin);
            if (eachResult == -1) {
                continue;
            }
            result = Math.min(result, 1 + eachResult);
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public static void main(String[] args) {
        List<Integer> canUseCoinList = Arrays.asList(1, 2, 5, 10);
        List<Integer> minCoinCombinationList = Lists.newArrayList();
        System.out.println(new CoinTip().findMinCoinTipCombination(canUseCoinList, 22));
    }
}
