/*
 * Kaune
 * April 4,2022
 */
package testsearch;
import javax.swing.*;
/**
 *
 * @author Administrator
 */
public class TestSearch {

    public static int loopCounter, comparisonCounter, shiftCounter;

    public static void main(String[] args) {
        loopCounter = 0;
        comparisonCounter = 0;
        shiftCounter = 0;
        int arraySize;
        String myInput = JOptionPane.showInputDialog("How many random numbers do you wish to generate?");
        arraySize = Integer.parseInt(myInput);

        int nums[] = new int[arraySize];

        for (int i = 0; i < arraySize; i++) {
            nums[i] = (int) (Math.random() * 1000);
        }

        //Display the unsorted list
        System.out.println("The unsorted list is:");
        for (int i = 0; i < arraySize; i++) {
            System.out.println(nums[i]);
        }
        System.out.println("\n------------------------------------");

        int target = Integer.parseInt(JOptionPane.showInputDialog("What number do you want to search for?"));

        long time = -1; //timer variable

        boolean isFound = false;

        System.out.println("Perfoming Linear Search (unsorted list)");
        time = System.currentTimeMillis();
        isFound = unsortedLinearSearch(nums, target);
        time = System.currentTimeMillis() - time;

        System.out.println("Search returned : " + isFound);
        System.out.println("Processing Time: " + time + "ms");
        System.out.println("loopCounter = " + loopCounter);
        System.out.println("comparisonCounter = " + comparisonCounter);
        System.out.println("\n------------------------------------");
        loopCounter = 0;
        comparisonCounter = 0;
        // Collections.sort(<ArrayList>)
        System.out.println("Performing Linear Search (sorted list)");
        quickSort(nums, 0, nums.length - 1);
        time = System.currentTimeMillis();
        isFound = linearSearch(nums, target);
        time = System.currentTimeMillis() - time;

        System.out.println("Search returned : " + isFound);
        System.out.println("Processing Time: " + time + "ms");
        System.out.println("loopCounter = " + loopCounter);
        System.out.println("comparisonCounter = " + comparisonCounter);
        System.out.println("\n------------------------------------");
        loopCounter = 0;
        comparisonCounter = 0;

        System.out.println("Performing Binary Search");
        time = System.currentTimeMillis();
        isFound = binarySearch(nums, 0, nums.length - 1, target);
        time = System.currentTimeMillis() - time;

        System.out.println("Search returned : " + isFound);
        System.out.println("Processing Time: " + time + "ms");
        System.out.println("loopCounter = " + loopCounter);
        System.out.println("comparisonCounter = " + comparisonCounter);
    }

    public static boolean unsortedLinearSearch(int myArray[], int v) {
        int k;
        for (k = 0; k < myArray.length; k++) {
            loopCounter++;
            comparisonCounter++;
            if (myArray[k] == v) {
                return true;
            }
        }
        return false;
    }

    public static boolean linearSearch(int myArray[], int v) {
        //The array must be sorted.
        int k;
        for (k = 0; k < myArray.length; k++) {
            loopCounter++;
            comparisonCounter++;
            if (myArray[k] == v) {
                return true;
            }
            comparisonCounter++;
            if (myArray[k] > v) {
                return false;
            }
        }
        return false;
    }

    public static boolean binarySearch(int myArray[], int left, int right, int v) {
        loopCounter++;
        int middle;
        comparisonCounter++;
        if (left > right) {
            return false;
        }
        middle = (left + right) / 2;
        comparisonCounter++;
        if (myArray[middle] == v) {
            return true;
        }
        comparisonCounter++;
        if (v < myArray[middle]) {
            return binarySearch(myArray, left, middle - 1, v);
        } else {
            return binarySearch(myArray, middle + 1, right, v);
        }
    }

    public static void quickSort(int data[], int low, int high) {
// Code for quickSort has been removed
    }

    public static int partition(int data2[], int left, int right) {
// Code for Partition has been removed
        return 0;
    }
}