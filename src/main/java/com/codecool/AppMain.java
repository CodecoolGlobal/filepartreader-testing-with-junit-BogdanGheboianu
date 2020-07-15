package com.codecool;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AppMain {
    private static String filePath = "";
    private static final int toLine = 2;
    private static final int fromLine = 1;
    private static final String subString = "no";

    public static void main(String[] args) throws IOException {
        setFilePath();

        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup(filePath, fromLine, toLine);
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);

        System.out.println("WORDS ORDERED ALPHABETICALLY:\n" + fileWordAnalyzer.getWordsOrderedAlphabetically() + "\n\n");
        System.out.println("WORDS CONTAINING THE SUBSTRING <" + subString + ">:\n" + fileWordAnalyzer.getWordsContainingSubstring(subString) + "\n\n");
        System.out.println("PALINDROME WORDS:\n" + fileWordAnalyzer.getStringsWhichPalindromes());
    }

    public static void setFilePath() {
        Path currentDir = Paths.get(".");
        filePath = currentDir.toAbsolutePath().toString() + "\\src\\main\\resources\\file.txt";
    }
}
