package com.codecool;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

public class FilePartReaderTest {
    @Test
    public void testToLineSmallerThanFromLineThrowsException() {
        FilePartReader fpr = new FilePartReader();
        assertThrows(IllegalArgumentException.class, () -> fpr.setup("filePath", 3, 2));
    }

    @Test
    public void testFromLineSmallerThan1ThrowsException() {
        FilePartReader fpr = new FilePartReader();
        assertThrows(IllegalArgumentException.class, () -> fpr.setup("filePath", 0, 3));
    }

    @Test
    public void testFileNotFoundThrowsException() {
        FilePartReader fpr = new FilePartReader();
        fpr.setup("invalid_file_path", 2, 3);
        assertThrows(IOException.class, () -> fpr.read());
    }

    @Test
    public void testFileContentIsNotNull() throws IOException {
        FilePartReader fpr = new FilePartReader();
        Path currentDir = Paths.get(".");
        String filePath = currentDir.toAbsolutePath().toString() + "\\src\\test\\resources\\testFile.txt";
        fpr.setup(filePath, 2, 3);
        assertNotNull(fpr.read());
    }

    @Test
    public void testSelectedLinesAreNotNull() throws IOException {
        FilePartReader fpr = new FilePartReader();
        Path currentDir = Paths.get(".");
        String filePath = currentDir.toAbsolutePath().toString() + "\\src\\test\\resources\\testFile.txt";
        fpr.setup(filePath, 2, 3);
        assertNotNull(fpr.readLines());
    }
}
