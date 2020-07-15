package com.codecool;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileWordAnalyzer {
    private final FilePartReader filePartReader;

    public FileWordAnalyzer(FilePartReader filePartReader) {
        this.filePartReader = filePartReader;
    }

    public List<String> getWordsOrderedAlphabetically() throws IOException {
        List<String> wordsList = getWordsListFromContent();
        return wordsList.stream().sorted().distinct().collect(Collectors.toList());
    }

    public List<String> getWordsContainingSubstring(String subString) throws IOException {
        List<String> wordsList = getWordsListFromContent();
        return wordsList.stream().filter(word -> word.contains(subString)).distinct().collect(Collectors.toList());
    }

    public List<String> getStringsWhichPalindromes() throws IOException {
        List<String> wordsList = getWordsListFromContent();
        return wordsList.stream().filter(this::isPalindrome).distinct().collect(Collectors.toList());
    }

    private List<String> getWordsListFromContent() throws IOException {
        String content = filePartReader.readLines();
        List<String> wordsList = Arrays.asList(content.split(" "));
        return cleanUpWordsList(wordsList);
    }

    private List<String> cleanUpWordsList(List<String> wordsList) {
        List<String> cleanWordsList = new ArrayList<>();
        for (int i = 0; i < wordsList.size(); i++) {
            cleanWordsList.add(wordsList.get(i)
                            .replace("\n", "")
                            .replace(".", "")
                            .toLowerCase());

        }
        return cleanWordsList;
    }

    private boolean isPalindrome(String word) {
        int i = 0, j = word.length() - 1;
        while (i < j) {
            if (word.charAt(i) != word.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
