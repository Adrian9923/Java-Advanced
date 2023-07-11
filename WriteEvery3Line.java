package Demo;

import java.io.*;

public class WriteEvery3Line {
    public static void main(String[] args) {
        String inputPath = "input.txt";
        String outputPath = "05.WriteEveryThirdLineOutput.txt";

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(inputPath));
            PrintWriter printWriter = new PrintWriter(new FileWriter(outputPath))) {
            int counter = 1;
            String line = bufferedReader.readLine();

            while (line != null) {
                if (counter % 3 == 0){
                    printWriter.println(line);
                }
                counter++;
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
