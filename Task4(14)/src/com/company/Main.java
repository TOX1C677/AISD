package com.company;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("input1.txt");
        FileInputStream fis = new FileInputStream(file);
        byte[] data = new byte[(int) file.length()];
        fis.read(data);
        fis.close();

        String input = new String(data, StandardCharsets.UTF_8);
        List<String> res = Task.solve(input);
        for (String str : res) {
            System.out.println(str);
        }
    }
}
