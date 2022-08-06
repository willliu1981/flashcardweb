package leetcode.test1;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Solution {

	public String findLongestWord(String input, List<String> dictionaries) {

		List<String> stores = new ArrayList<>();

		Pattern pattern = null;
		Matcher matcher = null;

		for (String dict : dictionaries) {

			String regex = dict.chars().mapToObj(ch -> "" + (char) ch)
					.collect(Collectors.joining(".*", ".*", ".*"));

			pattern = Pattern.compile(regex);
			matcher = pattern.matcher(input);

			if (matcher.find()) {
				stores.add(dict);
			}

		}

		String find = stores.stream().sorted((a1, a2) -> a1.compareTo(a2))
				.sorted((a1, a2) -> a2.length() - a1.length()).findFirst()
				.orElse("");

		return find;
	}

}

public class BinaryTreePaths {

	public static void main(String[] args) {

		String input = "abpcplea";
		List<String> dictionaries = Stream
				.of(new String[] { "ale", "apple", "monkey", "plea" })
				.collect(Collectors.toList());
		//String[] dictionaries = { "abe", "abc" };

		String find = new Solution().findLongestWord(input, dictionaries);

		System.out.println("result=" + find);

	}

}
