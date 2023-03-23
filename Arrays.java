import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
* This program calculates median, mode
* and mean by using arrays & writing to file.
*
*
* @author  Sarah Andrew
* @version 1.0
*
* @since   2023-03-22
*/

public final class Arrays {

    /**
     * This is a private constructor used to satisfy the
     * style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */
    private Arrays() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This is the main method.
     *
     * @param args Unused.
     */
    public static void main(String[] args) {
        // Pass path to file as parameter.
        final File file = new File("set3.txt");
        final File fileOut = new File("output.txt");

        // Create a new list.
        final List<String> listOfStrings =
            new ArrayList<String>();

        // Declare variable.
        String stringList;

        try {
            // Create FileWriter object to write to file.
            final FileWriter fW = new FileWriter(fileOut);
            // Create Scanner object to read from file.
            final Scanner sc = new Scanner(file);
            // Create PrintWriter object to write to file.
            final PrintWriter write = new PrintWriter(fW);

            while (sc.hasNextLine()) {
                // Read line as string.
                stringList = sc.next();
                // Adding each string to list.
                listOfStrings.add(stringList);
            }

            // Convert from list to array.
            final String[] arrayOfStr =
                listOfStrings.toArray(new String[0]);

            // Convert all elements in array to an integers.
            // To do so, loop through each element & convert
            // each string.
            final int[] arrayNum =
                new int[arrayOfStr.length];
            for (int counter = 0; counter < arrayNum.length; counter++) {
                arrayNum[counter] = Integer.parseInt(arrayOfStr[counter]);
            }

            // Sort each element in array.
            java.util.Arrays.sort(arrayNum);

            // Call function.
            final double userMean = calcMean(arrayNum);
            final double userMedian = calcMedian(arrayNum);
            final int[] userMode = calcMode(arrayNum);

            // Print number of set to user.
            System.out.println(listOfStrings);

            // Display to user.
            System.out.println("The mean is: " + userMean);
            System.out.println("The median is: "
                    + userMedian);
            System.out.println("The mode is: "
                + java.util.Arrays.toString(userMode));

            // Display in file.
            write.println("The mean is: " + userMean);
            write.println("The median is: "
                + userMedian);
            write.println("The mode is: "
                + java.util.Arrays.toString(userMode));

            // Closes scanner & writer.
            write.close();
            sc.close();
        } catch (IOException error) {
            System.out.println("An error occurred: "
                    + error.getMessage());
        }
    }

    /**
    * This function calculates mean of numbers,
    * in set.
    *
    * @param arrayNums passed
    * @return mean.
    */
    public static double calcMean(int arrayNums[]) {
        // Declare variables.
        double sum = 0;
        double mean = 0;

        // Loop to calculate mean, access all elements.
        for (int num : arrayNums) {
            sum = sum + num;
            mean = sum / arrayNums.length;
        }
        // Return back to main.
        return mean;
    }

    /**
    * This function calculates median of numbers,
    * in set.
    *
    * @param arrayNums passed.
    * @return median.
    */
    public static double calcMedian(int arrayNums[]) {
        // Declare variables.
        double median = 0;
        final int aNum = arrayNums.length;

        // Calculate median, check for cases.
        // Case if even.
        if (aNum % 2 == 0) {
            // Calculate average of two terms.
            median = (arrayNums[aNum / 2 - 1]
                    + arrayNums[aNum / 2]) / 2;
        } else {
            // Case if odd.
            median = arrayNums[aNum / 2];
        }
        // Return back to main.
        return median;
    }
    /**
    * This function calculates mode of numbers,
    * in set.
    *
    * @param arrayNums passed.
    * @return arrayMode.
    */
    public static int[] calcMode(int[] arrayNums) {
        // Declare variables.
        int maxCount = 0;
        int counter = 0;
        int counter2 = 0;
        final int num = arrayNums.length;

        // Create an arraylist.
        final ArrayList<Integer> listOfModes =
            new ArrayList<Integer>();

        // Find the maximum count of any repeating elements.
        for (counter = 0; counter < num; counter++) {
            int count = 0;
            for (counter2 = 0; counter2 < num; counter2++) {
                if (arrayNums[counter2] == arrayNums[counter])
                    count++;
            }
            // Clear array if count > maxCount,
            // if it's equalled to add the element
            // to list.
            if (count > maxCount) {
                maxCount = count;
                listOfModes.clear();
                listOfModes.add(arrayNums[counter]);
            } else if (count == maxCount) {
                listOfModes.add(arrayNums[counter]);
            }
        }
        // Remove duplicates.
        if (listOfModes.size() > 1) {
            int number = 1;
            while (number < listOfModes.size()) {
                if (listOfModes.get(number) == listOfModes.get(number - 1)) {
                    listOfModes.remove(number);
                } else {
                    number++;
                }
            }
        }
        // Convert from list to array.
        final int[] arrayMode = new int[listOfModes.size()];
        for (int counter4 = 0; counter4 < arrayMode.length; counter4++) {
            arrayMode[counter4] = listOfModes.get(counter4);
        }
        // Return array back to main.
        return arrayMode;
    }
}
