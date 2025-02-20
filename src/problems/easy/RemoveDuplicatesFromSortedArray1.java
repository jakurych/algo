package problems.easy;

import java.util.Arrays;
import java.util.HashSet;
/*
Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once.
The relative order of the elements should be kept the same. Then return the number of unique elements in nums.

Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:

Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially.
The remaining elements of nums are not important as well as the size of nums.
Return k.
 */
public class RemoveDuplicatesFromSortedArray1 {

    //algorytm
    public int removeDuplicates(int[] nums) {

        HashSet<Integer> unique = new HashSet<Integer>();
        for(int i=0; i < nums.length; i++){
            if(unique.contains(nums[i])){
                continue;
            }
            unique.add(nums[i]);
        }

        int j = 0;
        for(int n : unique){
            nums[j] = n;
            j++;
        }
        int max = Arrays.stream(nums).max().getAsInt();
        for(int k = j; k< nums.length; k++){
            nums[k] = max+1;
        }

        Arrays.sort(nums);

        return unique.size();

    }


    //testy
    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray1 solver = new RemoveDuplicatesFromSortedArray1();

        // Test 1: Standardowy przypadek z duplikatami
        test(new int[]{1, 1, 2}, 2);

        // Test 2: Brak duplikatów
        test(new int[]{1, 2, 3, 4, 5}, 5);

        // Test 3: Wszystkie elementy są takie same
        test(new int[]{2, 2, 2, 2, 2}, 1);

        /*// Test 4: Pusta tablica
        test(new int[]{}, 0);*/

        // Test 5: Tablica z jednym elementem
        test(new int[]{5}, 1);

        // Test 6: Duplikaty na końcu
        test(new int[]{1, 2, 3, 4, 4}, 4);

        // Test 7: Duplikaty na początku
        test(new int[]{1, 1, 2, 3, 4}, 4);

        // Test 8: Mieszane liczby
        test(new int[]{1, 2, 2, 3, 3, 4}, 4);
    }




    private static void test(int[] nums, int expected) {
        RemoveDuplicatesFromSortedArray1 solver = new RemoveDuplicatesFromSortedArray1();
        int result = solver.removeDuplicates(nums);

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
