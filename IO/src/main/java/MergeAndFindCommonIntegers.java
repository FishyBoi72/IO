import java.io.*;
import java.util.*;

public class MergeAndFindCommonIntegers {

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        Set<Integer> commonIntegers = new HashSet<>();
        
        try (BufferedReader br1 = new BufferedReader(new InputStreamReader(
                MergeAndFindCommonIntegers.class.getResourceAsStream("/input1.txt")))) {
            String line;
            while ((line = br1.readLine()) != null) {
                try {
                    int num = Integer.parseInt(line.trim());
                    list1.add(num);
                } catch (NumberFormatException e) {
                    System.err.println("Skipping invalid number in input1.txt: " + line);
                }
            }
        } catch (NullPointerException e) {
            System.err.println("File input1.txt not found in resources.");
        } catch (IOException e) {
            System.err.println("Error reading from input1.txt.");
        }

        try (BufferedReader br2 = new BufferedReader(new InputStreamReader(
                MergeAndFindCommonIntegers.class.getResourceAsStream("/input2.txt")))) {
            String line;
            while ((line = br2.readLine()) != null) {
                try {
                    int num = Integer.parseInt(line.trim());
                    list2.add(num);
                } catch (NumberFormatException e) {
                    System.err.println("Skipping invalid number in input2.txt: " + line);
                }
            }
        } catch (NullPointerException e) {
            System.err.println("File input2.txt not found in resources.");
        } catch (IOException e) {
            System.err.println("Error reading from input2.txt.");
        }

        File outputDir = new File("output");
        if (!outputDir.exists()) {
            outputDir.mkdir();
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter("output/merged.txt"))) {
            for (int num : list1) {
                writer.println(num);
            }
            for (int num : list2) {
                writer.println(num);
            }
        } catch (IOException e) {
            System.err.println("Error writing to merged.txt.");
        }

        Set<Integer> set1 = new HashSet<>(list1);
        for (int num : list2) {
            if (set1.contains(num)) {
                commonIntegers.add(num);
            }
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter("output/common.txt"))) {
            for (int num : commonIntegers) {
                writer.println(num);
            }
        } catch (IOException e) {
            System.err.println("Error writing to common.txt.");
        }
    }
}