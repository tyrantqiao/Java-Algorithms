package sort;

import java.util.List;

@FunctionalInterface
public interface Sort<T> {
	T sorting(T t);

//	static <T> Sort<T, T> identity() {
//		return t -> t;
//	}

}
