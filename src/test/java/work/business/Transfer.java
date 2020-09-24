package work.business;

import org.apache.tomcat.jni.Local;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * @author tyrantqiao
 * @date 2020/8/30
 * email: tyrantqiao@gmail.com
 */
public class Transfer {
    /**
     * 自带去0的操作，转换时
     * while (i < len) {
     * // Accumulating negatively avoids surprises near MAX_VALUE
     * int digit = Character.digit(s.charAt(i++), radix);
     * if (digit < 0 || result < multmin) {
     * throw NumberFormatException.forInputString(s, radix);
     * }
     * result *= radix;
     * if (result < limit + digit) {
     * throw NumberFormatException.forInputString(s, radix);
     * }
     * result -= digit;
     * }
     */
    @Test
    public void testTransferZero() {
        String s = "000000001";
        String s2 = "00000001.2";
        Assertions.assertEquals(Integer.parseInt(s), 1);
        Assertions.assertEquals(new BigDecimal(s2).toString(), "1.2");
    }

    @Test
    public void testTimeStamp() {
        Long timestamp = 1588759080000L;
        LocalDateTime time = LocalDateTime.ofInstant(Instant.ofEpochSecond(timestamp), ZoneId.systemDefault());
        System.out.println(time.toString());
    }
}
