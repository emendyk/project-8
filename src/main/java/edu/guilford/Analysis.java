package edu.guilford;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;



public class Analysis {
    public static void main(String[] args) {
        File inputFile = new File("paper.txt");
        Map<String, Integer> wordCounts = new HashMap<String, Integer>();

        try (Scanner scanner = new Scanner(inputFile)) {
            while (scanner.hasNext()) {
                String word = scanner.next();
                // Remove any non-alphabetic characters
                word = word.replaceAll("[^a-zA-Z]", "");
                if (!word.isEmpty()) {
                    word = word.toLowerCase();
                    if (wordCounts.containsKey(word)) {
                        wordCounts.put(word, wordCounts.get(word) + 1);
                    } else {
                        wordCounts.put(word, 1);
                    }
                }
            }
        // add an exception handler to catch any errors in the input file
        } catch (IOException e) {
            System.err.println("Error reading input file: " + e.getMessage());
            return;
        }

        // Sort the word counts by frequency in descending order
        // I used ArrayList instead of array I hope that is acceptable
        // for the purpose of this project
        List<Words> wordsList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            wordsList.add(new Words(entry.getKey(), entry.getValue()));
        }
        Collections.sort(wordsList);

        // Write the sorted word counts to a file 
        File outputFile = new File("sorted_words.txt");
        try (FileWriter writer = new FileWriter(outputFile)) {
            for (Words word : wordsList) {
                writer.write(word.getWord() + " " + word.getCount() + "\n");
            }
        // add an exception handler to catch any errors in the output file
        } catch (IOException e) {
            System.err.println("Error writing output file: " + e.getMessage());
            return;
        }
        // print out the sorted word counts
        System.out.println("Done. Sorted word counts written to sorted_words.txt.");
    }
}
