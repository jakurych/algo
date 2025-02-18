package problems.easy;

import java.util.Arrays;

/*

You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 */
public class MergeSortedArray {

    private static void test(int[] nums1, int m, int[] nums2, int n, int[] expected) {
        MergeSortedArray solver = new MergeSortedArray();
        solver.merge(nums1, m, nums2, n);

        if (Arrays.equals(nums1, expected)) {
            System.out.println("✅ Test passed: " + Arrays.toString(nums1));
        } else {
            System.out.println("❌ Test failed: Expected " + Arrays.toString(expected) + " but got " + Arrays.toString(nums1));
        }
    }

    public static void main(String[] args) {
        test(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3, new int[]{1, 2, 2, 3, 5, 6});
        test(new int[]{1}, 1, new int[]{}, 0, new int[]{1});
        test(new int[]{0}, 0, new int[]{1}, 1, new int[]{1});
        test(new int[]{4, 5, 6, 0, 0, 0}, 3, new int[]{1, 2, 3}, 3, new int[]{1, 2, 3, 4, 5, 6});
        test(new int[]{1, 2, 3, 4, 5, 6, 0, 0}, 6, new int[]{7, 8}, 2, new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        test(new int[]{1, 1, 1, 0, 0, 0}, 3, new int[]{1, 1, 1}, 3, new int[]{1, 1, 1, 1, 1, 1});
        test(new int[]{2, 0}, 1, new int[]{1}, 1, new int[]{1, 2});
        test(new int[]{1, 2, 4, 5, 6, 0}, 5, new int[]{3}, 1, new int[]{1, 2, 3, 4, 5, 6});
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        //add to the end of nums1
        for(int i = m, j=0; j<n ; j++, i++){
            nums1[i] = nums2[j];
        }
        //sort
        Arrays.sort(nums1);
    }
}
