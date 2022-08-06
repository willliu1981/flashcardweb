package leetcode.test2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
	public int findKthLargest(int[] nums, int k) {
		List<Integer> list = Arrays.stream(nums).boxed()
				.sorted((a1, a2) -> a2 - a1).collect(Collectors.toList());

		return list.get(k - 1);
	}
}

public class KthLargestElementInAnArray {

	public static void main(String[] args) {

		int[] nums = new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
		int[] nums2 = new int[] { 3, 2, 1, 5, 6, 4 };

		int k = 2;

		int findKthLargest = new Solution().findKthLargest(nums2, k);

		System.out.println(findKthLargest);

	}

}
