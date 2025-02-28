package problems.easy;

import java.util.Arrays;

/*
121. Best Time to Buy and Sell Stock
You are given an array prices where prices[i]
 is the price of a given stock on the ith day.

You want to maximize your profit by choosing
a single day to buy one stock and choosing a different
day in the future to sell that stock.

Return the maximum profit you can achieve from this
transaction.
If you cannot achieve any profit, return 0.
 */
public class BestTimeToBuyAndSellStock {

    //alg
    public int maxProfit(int[] prices) {
        int maxProfit=0;
        int minPrice = prices[0];

        for(int i = 0; i < prices.length; i++){
            maxProfit = Math.max(maxProfit, prices[i]-minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }

        return maxProfit;

    }



    //tests
    private static void test(int[] prices, int expected) {
        BestTimeToBuyAndSellStock solver = new BestTimeToBuyAndSellStock();
        int result = solver.maxProfit(prices);

        if (result == expected) {
            System.out.println("✅ Test passed for input " + Arrays.toString(prices) + ": expected " + expected + ", got " + result);
        } else {
            System.out.println("❌ Test failed for input " + Arrays.toString(prices) + ": expected " + expected + ", got " + result);
        }
    }

    public static void main(String[] args) {
        // Test 1: Standardowy przypadek
        test(new int[]{7, 1, 5, 3, 6, 4}, 5); // Kupujemy za 1, sprzedajemy za 6

        // Test 2: Ciągle malejące ceny (brak możliwości zysku)
        test(new int[]{7, 6, 4, 3, 1}, 0); // Nie da się zarobić

        // Test 3: Jeden dzień (brak możliwości zakupu i sprzedaży)
        test(new int[]{5}, 0); // Brak możliwości transakcji

        // Test 4: Ceny już posortowane rosnąco (największy możliwy zysk)
        test(new int[]{1, 2, 3, 4, 5}, 4); // Kupujemy za 1, sprzedajemy za 5

        // Test 5: Ceny z wahaniami, ale najlepsza strategia to kupno na początku i sprzedaż na szczycie
        test(new int[]{3, 2, 6, 5, 0, 3}, 4); // Kupujemy za 2, sprzedajemy za 6

        // Test 6: Wszystkie ceny są takie same (brak możliwości zarobku)
        test(new int[]{2, 2, 2, 2, 2}, 0);
    }
}
