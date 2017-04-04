package util;

import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Created by Beniamin on 3/7/2017.
 */
public class FileWriter {

    public static void writeToFile(String fileName, String data) {

        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(fileName))) {

            writer.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
