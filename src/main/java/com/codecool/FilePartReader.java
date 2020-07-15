package com.codecool;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class FilePartReader {
    private String filePath;
    private int toLine;
    private int fromLine;

    public void setup(String filePath, int fromLine, int toLine) {
        if (toLine < fromLine || fromLine < 1) throw new IllegalArgumentException("toLine cannot be smaller than fromLine and fromLine cannot be smaller than 1");
        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;
    }

    public String read() throws IOException {
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);
        StringBuilder stringBuilder = new StringBuilder();
        while (scanner.hasNextLine()) {
            stringBuilder.append(scanner.nextLine()).append("\n");
        }
        return stringBuilder.toString();
    }

    public String readLines() throws IOException {
        String content = read();
        String[] contentLinesList = content.split("\n");
        String[] selectedContentLinesList = Arrays.copyOfRange(contentLinesList, fromLine - 1, toLine);
        return String.join("\n", selectedContentLinesList);
    }
}
