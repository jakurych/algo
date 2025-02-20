package problems.easy;
/*
Given an integer array nums, return true if any value appears more than once in the array, otherwise return false.
Example 1:
Input: nums = [1, 2, 3, 3]
Output: true
Example 2:
Input: nums = [1, 2, 3, 4]
Output: false
 */

import java.util.HashSet;

public class ContainsDuplicate {

    //Właściwy algorytm
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            } else {
                set.add(nums[i]);
            }
        }
        return false;
    }

    //testowe

    public static void main(String[] args) {
        ContainsDuplicate solver = new ContainsDuplicate();

        // Test 1: Podstawowy test z duplikatem
        test(new int[]{1, 2, 3, 3}, true);

        // Test 2: Podstawowy test bez duplikatu
        test(new int[]{1, 2, 3, 4}, false);

        // Test 3: Pusta tablica
        test(new int[]{}, false);

        // Test 4: Jeden element
        test(new int[]{1}, false);

        // Test 5: Wszystkie elementy są takie same
        test(new int[]{2, 2, 2, 2}, true);

        // Test 6: Duplikaty na końcu
        test(new int[]{1, 2, 3, 4, 4}, true);

        // Test 7: Duplikaty na początku
        test(new int[]{1, 1, 2, 3, 4}, true);

        // Test 8: Liczby ujemne
        test(new int[]{-1, -2, -3, -1}, true);

        // Test 9: Duże liczby
        test(new int[]{1000000, 1000001, 1000000}, true);

        // Test 10: Mieszane liczby dodatnie i ujemne
        test(new int[]{-1, 0, 1, 2, -1}, true);
    }

    private static void test(int[] nums, boolean expected) {
        ContainsDuplicate solver = new ContainsDuplicate();
        boolean result = solver.containsDuplicate(nums);

        if (result == expected) {
            System.out.println("✅ Test passed for array: " + arrayToString(nums) +
                    "\nExpected: " + expected + ", Got: " + result);
        } else {
            System.out.println("❌ Test failed for array: " + arrayToString(nums) +
                    "\nExpected: " + expected + ", Got: " + result);
        }
        System.out.println(); // pusta linia dla czytelności
    }

    private static String arrayToString(int[] arr) {
        if (arr.length == 0) return "[]";

        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arr.length - 1; i++) {
            sb.append(arr[i]).append(", ");
        }
        sb.append(arr[arr.length - 1]).append("]");
        return sb.toString();
    }


}



