package problems.easy;

import java.util.Arrays;

public class MajorityElement {

    public int majorityElement(int[] nums) {
        int majority = nums.length / 2;
        // number -> quantity
        java.util.HashMap<Integer, Integer> mapa = new java.util.HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (mapa.containsKey(nums[i])) {
                mapa.put(nums[i], mapa.get(nums[i]) + 1);
            } else {
                mapa.put(nums[i], 1);
            }
        }

        for (java.util.Map.Entry<Integer, Integer> entry : mapa.entrySet()) {
            if (entry.getValue() > majority) {
                return entry.getKey();
            }
        }
        return 0;
    }

    private static void test(int[] nums, int expected) {
        MajorityElement solver = new MajorityElement();
        int result = solver.majorityElement(nums);

        if (result == expected) {
            System.out.println("✅ Test passed for input " + Arrays.toString(nums) + ": expected " + expected + ", got " + result);
        } else {
            System.out.println("❌ Test failed for input " + Arrays.toString(nums) + ": expected " + expected + ", got " + result);
        }
    }

    public static void main(String[] args) {
        // Test 1: Klasyczny przypadek
        test(new int[]{3, 2, 3}, 3);

        // Test 2: Większość to 2
        test(new int[]{2, 2, 1, 1, 1, 2, 2}, 2);

        // Test 3: Tylko jeden element
        test(new int[]{1}, 1);

        // Test 4: Wszystkie elementy takie same
        test(new int[]{4, 4, 4, 4, 4}, 4);

        // Test 5: Większość występuje dokładnie ponad połowę razy
        test(new int[]{1, 1, 2, 1, 3, 1, 1}, 1);

        // Test 6: Test z większym rozkładem ale wyraźną większością
        test(new int[]{6, 6, 6, 7, 7, 6, 8, 6, 6}, 6);
    }
}
