package test;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test1 {

	public static void main(String[] args) {

		String[] s1 = { "aaa", "bbb" };
		String[] s2 = { "aaa2", "bbb2" };
		
		Integer [] i1= {1,2};
		Integer [] i2= {11,12};
		Integer [] i3= {111,222,333};

		String[] ss1 =  Stream.of(Stream.of(s1), Stream.of(s2)).flatMap(x -> x)
				.toArray(x -> new String[s1.length + s2.length]);
		
		Integer[] ii1 =  Stream.of(Stream.of(i1), Stream.of(i2)).flatMap(x -> x)
				.toArray(x -> new Integer[i1.length + i2.length]);
		
		Integer[] ii2=Stream.of(Stream.of(i3) ,Stream.of(444)).flatMap(x->x) .toArray(x->new Integer[i3.length+1]);


		/*
		for (String s : ss1) {
			System.out.println(s);
		}
		//*/
		
		
		for (Integer s : ii2) {
			System.out.println(s);
		}
		
		Map<String,Integer> map=new HashMap<>();
		map.put("aa", 11);
		map.put("bb", 22);
		
		System.out.println(map.get("cc"));

	}

}
