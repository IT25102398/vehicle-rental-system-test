package com.vehiclerental.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    // Read All Lines From File
    public static List<String> readFile(String filePath) {

        List<String> lines = new ArrayList<>();

        try {

            BufferedReader reader = new BufferedReader(
                    new FileReader(filePath)
            );

            String line;

            while ((line = reader.readLine()) != null) {

                lines.add(line);
            }

            reader.close();

        } catch (IOException e) {

            e.printStackTrace();
        }

        return lines;
    }

    // Write Single Line to File
    public static boolean writeFile(String filePath, String data) {

        try {

            BufferedWriter writer = new BufferedWriter(
                    new FileWriter(filePath, true)
            );

            writer.write(data);
            writer.newLine();

            writer.close();

            return true;

        } catch (IOException e) {

            e.printStackTrace();
            return false;
        }
    }
}
