package problems.medium;
/*
Design an algorithm to encode a list of strings to a single string. The encoded string is then decoded back to the original list of strings.
Please implement encode and decode
Example 1:
Input: ["neet","code","love","you"]
Output:["neet","code","love","you"]
Example 2:
Input: ["we","say",":","yes"]
Output: ["we","say",":","yes"]
 */

import java.util.ArrayList;
import java.util.List;
public class EncodeAndDecodeStrings {
    public static void main(String[] args) {
        List<String> input1 = List.of("neet", "code", "love", "you");
        String encoded1 = encode(input1);
        List<String> decoded1 = decode(encoded1);
        System.out.println(decoded1); // ["neet", "code", "love", "you"]

        List<String> input2 = List.of("we", "say", ":", "yes");
        String encoded2 = encode(input2);
        List<String> decoded2 = decode(encoded2);
        System.out.println(decoded2); // ["we", "say", ":", "yes"]

        List<String> input3 = List.of(""); // Przypadek z pustym ciągiem
        String encoded3 = encode(input3);
        List<String> decoded3 = decode(encoded3);
        System.out.println(decoded3); // [""]

        List<String> input4 = new ArrayList<>(); // Przypadek z pustą listą
        String encoded4 = encode(input4);
        List<String> decoded4 = decode(encoded4);
        System.out.println(decoded4); // []
    }

    public static String encode(List<String> strs) {
        StringBuilder result = new StringBuilder();
        for (String str : strs) {
            result.append(str.length()).append("#").append(str); //kodowanie długości i ciągu
        }
        return result.toString();
    }

    public static List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            int j = str.indexOf('#', i); //separator
            int length = Integer.parseInt(str.substring(i, j)); //długość
            i = j + 1; //wskaźnik na początek ciągu

            String part = str.substring(i, i + length); //Odczytaj
            result.add(part); //dodaj
            i += length; //Przesuń wskaźnik na koniec
        }

        return result;
    }
}