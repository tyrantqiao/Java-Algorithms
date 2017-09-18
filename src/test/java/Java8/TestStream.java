package Java8;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author qiao
 * email: tyrantqiao@icloud.com
 * time: 2017/9/18 21:25
 */
public class TestStream {

	@Test
	void testSort() {
//		List<Integer> result = Stream.iterate(10, i -> i - 1)
//				.limit(10)
//				.collect(Collectors.toList());
//		result.sort((a, b) -> a.compareTo(b));
		List<Integer> result= Arrays.asList(1,2,5,3,6,2,0,35,34,4,6);
		result.sort(Comparator.comparing(t -> t, (a, b) -> ((Comparable)a).compareTo(b)));
		System.out.println(result);

//		OptionalInt num = IntStream.iterate(1, i -> i + 1).limit(10).reduce((a, b) -> a > b ? a : b);
//		assert(num.toString().equals("1"));

//		assert (result.get(0) ==(Integer)10);
	}
}
