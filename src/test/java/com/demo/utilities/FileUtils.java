package com.demo.utilities;

import org.junit.Test;

import java.io.*;
import java.util.Scanner;

public class FileUtils {

    public static void writeIntoFile(String text) throws IOException {
        File file = new File(ConfigurationReader.getProperty("userdata"));

        FileWriter fileWriter = new FileWriter(file);

        PrintWriter pw = new PrintWriter(fileWriter);

        pw.write(text);

        pw.close();
        fileWriter.close();
    }

    @Test
    public void testWriter() throws IOException {
        writeIntoFile("tes_test");
    }

    public static String readFile() {
        String data = "";
        try {
            File file = new File(ConfigurationReader.getProperty("userdata"));
            Scanner reader = new Scanner(file);

            //assuming our file has single line only
            data = reader.nextLine();
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return data;

    }

    @Test
    public void testReader() {
        System.out.println(readFile());
    }
}
