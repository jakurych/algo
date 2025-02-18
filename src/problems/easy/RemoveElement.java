package problems.easy;

import java.util.Arrays;

/*


Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.

Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:

Change the array nums such that the first k elements of nums contain the elements which are not equal to val. The remaining elements of nums are not important as well as the size of nums.
Return k.
 */
public class RemoveElement {

    private static void test(int[] nums, int val, int expectedLength, int[] expectedArray) {
        RemoveElement solver = new RemoveElement();
        int result = solver.removeElement(nums, val);

        // Sprawdź długość
        boolean lengthCorrect = result == expectedLength;

        // Sprawdź zawartość tablicy (tylko do długości result)
        boolean contentCorrect = true;
        for (int i = 0; i < result; i++) {
            if (nums[i] != expectedArray[i]) {
                contentCorrect = false;
                break;
            }
        }

        if (lengthCorrect && contentCorrect) {
            System.out.println("✅ Test passed: length=" + result + ", array=" +
                    Arrays.toString(Arrays.copyOf(nums, result)));
        } else {
            System.out.println("❌ Test failed: Expected length=" + expectedLength +
                    ", got length=" + result + "\nExpected array=" +
                    Arrays.toString(Arrays.copyOf(expectedArray, expectedLength)) +
                    "\nActual array=" + Arrays.toString(Arrays.copyOf(nums, result)));
        }
    }

    public static void main(String[] args) {
        // Test 1: standardowy przypadek
        test(new int[]{3, 2, 2, 3}, 3, 2, new int[]{2, 2});

        // Test 2: wszystkie elementy różne od val
        test(new int[]{1, 2, 3, 4}, 5, 4, new int[]{1, 2, 3, 4});

        // Test 3: wszystkie elementy równe val
        test(new int[]{1, 1, 1, 1}, 1, 0, new int[]{});

        // Test 4: pusta tablica
        test(new int[]{}, 1, 0, new int[]{});

        // Test 5: jeden element równy val
        test(new int[]{1}, 1, 0, new int[]{});

        // Test 6: jeden element różny od val
        test(new int[]{1}, 2, 1, new int[]{1});

        // Test 7: mieszane wartości
        test(new int[]{4, 2, 3, 4, 2, 4}, 4, 3, new int[]{2, 3, 2});

        // Test 8: powtarzające się elementy
        test(new int[]{1, 2, 2, 2, 3, 3}, 2, 3, new int[]{1, 3, 3});
    }

    public int removeElement(int[] nums, int val) {
        int pointer = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]!=val){
                nums[pointer]=nums[i];
                pointer++;
            }
        }
        return pointer;
    }
}
