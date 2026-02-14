package com.automation.utils;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class JsonReader {

    public static String readJson(String fileName) {

        InputStream input = JsonReader.class
                .getClassLoader()
                .getResourceAsStream("testdata/" + fileName);

        Scanner scanner = new Scanner(input, StandardCharsets.UTF_8.name());
        return scanner.useDelimiter("\\A").next();
    }
}
