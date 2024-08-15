import java.io.*;
import java.util.*;

public class MergeAndFindCommonIntegers {

        public static void main(String[] args) {
        // Create an empty list to store integers from the first input file
        List<Integer> list1 = new ArrayList<>();
        // Create an empty list to store integers from the second input file
        List<Integer> list2 = new ArrayList<>();
        // Create an empty set to store common integers between the two lists
        Set<Integer> commonIntegers = new HashSet<>();
        
        // Try to open and read from the first input file
        try (BufferedReader br1 = new BufferedReader(new InputStreamReader(
                MergeAndFindCommonIntegers.class.getResourceAsStream("/input1.txt")))) {
            String line;
            // Read the file line by line
            while ((line = br1.readLine()) != null) {
                try {
                    // Parse each line as an integer and add it to list1
                    int num = Integer.parseInt(line.trim());
                    list1.add(num);
                } catch (NumberFormatException e) {
                    // Handle the case where a line isn't a valid integer
                    System.err.println("Skipping invalid number in input1.txt: " + line);
                }
            }
        } catch (NullPointerException e) {
            // Handle the case where input1.txt file is not found
            System.err.println("File input1.txt not found in resources.");
        } catch (IOException e) {
            // Handle any IO exceptions that occur while reading the file
            System.err.println("Error reading from input1.txt.");
        }

        // Try to open and read from the second input file
        try (BufferedReader br2 = new BufferedReader(new InputStreamReader(
                MergeAndFindCommonIntegers.class.getResourceAsStream("/input2.txt")))) {
            String line;
            // Read the file line by line
            while ((line = br2.readLine()) != null) {
                try {
                    // Parse each line as an integer and add it to list2
                    int num = Integer.parseInt(line.trim());
                    list2.add(num);
                } catch (NumberFormatException e) {
                    // Handle the case where a line isn't a valid integer
                    System.err.println("Skipping invalid number in input2.txt: " + line);
                }
            }
        } catch (NullPointerException e) {
            // Handle the case where input2.txt file is not found
            System.err.println("File input2.txt not found in resources.");
        } catch (IOException e) {
            // Handle any IO exceptions that occur while reading the file
            System.err.println("Error reading from input2.txt.");
        }

        // Create a new directory named "output" if it doesn't already exist
        File outputDir = new File("output");
        if (!outputDir.exists()) {
            outputDir.mkdir();
        }

        // Try to write all integers from list1 and list2 into a file named merged.txt
        try (PrintWriter writer = new PrintWriter(new FileWriter("output/merged.txt"))) {
            // Write each integer from list1 into the file
            for (int num : list1) {
                writer.println(num);
            }
            // Write each integer from list2 into the file
            for (int num : list2) {
                writer.println(num);
            }
        } catch (IOException e) {
            // Handle any IO exceptions that occur while writing the file
            System.err.println("Error writing to merged.txt.");
        }

        // Create a set from list1 to facilitate finding common elements
        Set<Integer> set1 = new HashSet<>(list1);
        // Check if each integer in list2 is present in set1, and if so, add it to commonIntegers
        for (int num : list2) {
            if (set1.contains(num)) {
                commonIntegers.add(num);
            }
        }

        // Try to write all common integers into a file named common.txt
        try (PrintWriter writer = new PrintWriter(new FileWriter("output/common.txt"))) {
            // Write each integer in commonIntegers into the file
            for (int num : commonIntegers) {
                writer.println(num);
            }
        } catch (IOException e) {
            // Handle any IO exceptions that occur while writing the file
            System.err.println("Error writing to common.txt.");
        }
    }
}
