package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author qiao
 * email: tyrantqiao@icloud.com
 * time: 2017/9/18 20:19
 */
public class SelectSort {
	public static <T> List<T> getListBySelect(Sort<T> sort,List<T> list){
		List<T> result=new ArrayList<>();
		for(T t:list){
			t=sort.sorting(t);
			result.add(t);
		}
		return result;
	}

//	public static void main(String[] args){
//		List<Integer> origin_list= new ArrayList<>();
//		origin_list.addAll(algorithms.iterate(10,i->i-1)
//									.limit(10)
//									.collect(Collectors.toList()));
////		System.out.println(origin_list);
//		List<Integer> result=getListBySelect((a)->{
//			algorithms.iterate(0,i->i+1)
//					.limit(10)
//					.reduce((Integer b,Integer c)->b<c?b:c)
////					.min((b,c)->b<c?b:c)
//
//		},origin_list);
//	}
}
