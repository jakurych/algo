package algorithms;

import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {

        int[] ints = {1,2,4,5,7,9,11};

        int index = binarySearch(ints,7);

        Arrays.binarySearch(ints,index); //build in library

        System.out.println(index);


    }

    private static int binarySearch(int[] arr, int numberToFind) {
        //pointers for first and last
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high)/2;
            int middleValue = arr[mid];
                if(middleValue == numberToFind) {
                    return mid;
                }
                if(middleValue > numberToFind) {
                    high = mid - 1;
                }
                if(middleValue < numberToFind){
                    low = mid + 1;
                }
        }
        return -1;
    }


}
