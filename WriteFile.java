package Demo;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WriteFile {
    public static void main(String[] args) {
        String inputPath = "input.txt";
        String outputPath = "02.WriteToFileOutput.txt";

        List<Character> symbols = new ArrayList<>();
        Collections.addAll(symbols, '.',',','!','?');

        try(InputStream inputStream = new FileInputStream(inputPath);
        OutputStream outputStream = new FileOutputStream(outputPath)) {
            int oneByte = 0;
            while ((oneByte = inputStream.read()) >= 0) {
                if (!symbols.contains((char)oneByte)) {
                    outputStream.write(oneByte);
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
