package interview;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author tyrantqiao
 * @date 2020/6/7
 * email: tyrantqiao@gmail.com
 */
public class StringTest {
    @Test
    public void testLocalTime() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
    }
}
