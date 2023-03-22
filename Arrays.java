import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

/**
* This program uses a loop to calculates the
* sum of numbers. It tells the user if input
* is valid or not, by reading file.
*
* @author  Sarah Andrew
* @version 1.0
*
* @since   2023-03-10
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
        final File file = new File("set1.txt");
        final File fileOut = new File("output.txt");

        // Create a new list.
        List<String> listOfStrings = new ArrayList<String>();

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
            String[] arrayOfStr = listOfStrings.toArray(new String[0]);

            // Convert all elements in array to an integers.
            // To do so, loop through each element & convert
            // each string.
            int[] arrayNum = new int[arrayOfStr.length];
            for (int counter = 0; counter < arrayNum.length; counter++) {
                arrayNum[counter] = Integer.parseInt(arrayOfStr[counter]);
            }

            // Sort each element in array.
            java.util.Arrays.sort(arrayNum);

            // Call function.
            final double userMean = calcMean(arrayNum);
            final double userMedian = calcMedian(arrayNum);

            // Print number of set to user.
            System.out.println(listOfStrings);

            // Display to user.
            System.out.println("The mean is: " + userMean);
            System.out.println("The median is: "
                + userMedian);

            // Display in file.
            write.println("The mean is: " + userMean);
            write.println("The median is: " + 
                    userMedian);

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
    * @param sum passed
    * @param mean passed.
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
    * @param median passed
    * @param aNum passed.
    * @return median.
    */
    public static double calcMedian(int arrayNums[]) {
        // Declare variables.
        double median = 0;
        int aNum = arrayNums.length;

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
}

