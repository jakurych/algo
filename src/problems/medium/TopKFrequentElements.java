package problems.medium;

import java.util.*;

/*
Given an integer array nums and an integer k, return the k most frequent elements within the array.

The test cases are generated such that the answer is always unique.

You may return the output in any order.

Example 1:

Input: nums = [1,2,2,3,3,3], k = 2

Output: [2,3]
Example 2:

Input: nums = [7,7], k = 1

Output: [7]
 */


    public class TopKFrequentElements {

        private static void test(int[] nums, int k, int[] expected) {
            TopKFrequentElements solver = new TopKFrequentElements();
            int[] result = solver.topKFrequent(nums, k);

            // Sortujemy obie tablice aby porównać zawartość niezależnie od kolejności
            Arrays.sort(result);
            Arrays.sort(expected);

            if (Arrays.equals(result, expected)) {
                System.out.println("✅ Test passed for nums=" + Arrays.toString(nums) +
                        ", k=" + k + "\nResult: " + Arrays.toString(result));
            } else {
                System.out.println("❌ Test failed for nums=" + Arrays.toString(nums) +
                        ", k=" + k + "\nExpected: " + Arrays.toString(expected) +
                        "\nGot: " + Arrays.toString(result));
            }
        }

        public static void main(String[] args) {
            // Test 1: Example from the problem description
            test(new int[]{1, 2, 2, 3, 3, 3}, 2, new int[]{2, 3});

            // Test 2: Another example from the problem description
            test(new int[]{7, 7}, 1, new int[]{7});

            // Test 3: All elements appear once
            test(new int[]{1, 2, 3, 4}, 2, new int[]{1, 2});

            // Test 4: Single element
            test(new int[]{1}, 1, new int[]{1});

            // Test 5: Multiple elements with same frequency
            test(new int[]{1, 1, 2, 2, 3, 3}, 2, new int[]{1, 2});

            // Test 6: Larger numbers
            test(new int[]{100, 100, 100, 200, 200, 300}, 2, new int[]{100, 200});

            // Test 7: Negative numbers
            test(new int[]{-1, -1, -2, -2, -2}, 1, new int[]{-2});

            // Test 8: k equals array length
            test(new int[]{1, 2, 3}, 3, new int[]{1, 2, 3});

            // Test 9: More complex frequency pattern
            test(new int[]{5, 5, 5, 5, 2, 2, 2, 1}, 2, new int[]{2, 5});
        }

        public int[] topKFrequent(int[] nums, int k) {

            HashMap<Integer, Integer> map = new HashMap<>();
            int[] result = new int[k];

            for (int number : nums) {
                //jesli zawiera klucz bedacy numerem, zwieksz licznosc
                //mapa <Liczba, Liczność>
                if (map.containsKey(number)) {
                    map.put(number, map.get(number) + 1);
                } else {
                    map.put(number, 1);
                }
            }

            //przezucilismy hashmape do listy
            List<Map.Entry<Integer, Integer>> lista = new ArrayList<>(map.entrySet());

            lista.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

            for (int i = 0; i < k; i++) result[i] = lista.get(i).getKey();

            return result;
        }
    }


            /*int result[] = new int[k];
            int result2[] = new int[k];
            HashMap<Integer, Integer> map = new HashMap<>();

            //utworzyć HashMape z <liczba, liczność>
            //klucz - liczba
            //value - liczność liczby

            for (int number : nums) {
                if (map.containsKey(number)) {
                    map.put(number, map.get(number) + 1);
                } else {
                    map.put(number, 1);
                }
            }
            System.out.println("\n\nMapa <numer, liczność>\n-----");
            System.out.println(map);
            System.out.println("-----");

            //znaleźć k największcych value i wyciągnąć klucz
            for (int key : map.keySet()) {
                int temp = map.get(key); //obecna wartość liczności

                //System.out.println(temp);
                //k największych liczebności
                for (int i = 0; i < k; i++) {
                    //spr czy w tablicy k są większe
                    if (result[i] < map.get(key)){
                        result[i] = temp;
                        result2[i] = key;
                        break;
                    }
                }
            }
            return result2;
        }*/