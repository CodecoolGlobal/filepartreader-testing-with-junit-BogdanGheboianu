package com.codecool;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Assert;

public class FileWordAnalyzerTest {
    private FilePartReader filePartReader;
    private FileWordAnalyzer fileWordAnalyzer;

    private void setup() {
        this.filePartReader = new FilePartReader();
        Path currentDir = Paths.get(".");
        String filePath = currentDir.toAbsolutePath().toString() + "\\src\\test\\resources\\testFile.txt";
        filePartReader.setup(filePath, 1, 2);
        this.fileWordAnalyzer = new FileWordAnalyzer(filePartReader);
    }

    @Test
    public void testGetWordsOrderedAlphabetically() throws IOException {
        setup();
        List<String> wordsList = fileWordAnalyzer.getWordsOrderedAlphabetically();
        Assert.assertArrayEquals(new List[]{Arrays.asList("abba", "air", "ball", "car", "did",
                                                            "hello", "java", "movement", "python", "world",
                                                            "yale", "zebra")}, new List[]{wordsList});
    }

    @Test
    public void testGetWordsContainingSubstring() throws IOException {
        setup();
        List<String> wordsList = fileWordAnalyzer.getWordsContainingSubstring("al");
        Assert.assertArrayEquals(new List[]{Arrays.asList("ball", "yale")}, new List[]{wordsList});
    }

    @Test
    public void testGetStringsWhichPalindromes() throws IOException {
        setup();
        List<String> wordsList = fileWordAnalyzer.getStringsWhichPalindromes();
        Assert.assertArrayEquals(new List[]{Arrays.asList("abba", "did")}, new List[]{wordsList});
    }
}
