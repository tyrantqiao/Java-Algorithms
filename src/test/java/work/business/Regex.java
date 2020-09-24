package work.business;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author tyrantqiao
 * @date 2020/8/30
 * email: tyrantqiao@gmail.com
 */
public class Regex {
    /**
     * split函数不加-1等限制分隔数目的话，对于s这类的字符串，末尾的空白是不会纳入期内的
     *
     *
     * 结果如下：
     * [1, 2, 3]
     * [1, 2, , 3]
     * [1, 2, 3, ]
     */
    @Test
    public void testSplit() {
        String s = "1,2,3,";
        System.out.println(Arrays.toString(s.split(",")));
        String s2 = "1,2,,3";
        System.out.println(Arrays.toString(s2.split(",")));

        System.out.println(Arrays.toString(s.split(",", -1)));

        assert Arrays.asList(s.split(",", -1)).size() != 3;
    }
}
