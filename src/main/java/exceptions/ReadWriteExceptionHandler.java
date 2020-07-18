package exceptions;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class ReadWriteExceptionHandler {

        private static String path =
                Paths.get("").toAbsolutePath().toString()+ "\\src\\main\\java\\exceptions\\data.txt";
        private File file = new File(path);

    public void appendDataToFile() {
        try {
            FileWriter fileWriter = new FileWriter(file);
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("Wprowadź liczbę (Q - wyjście)");
                double number = scanner.nextDouble();
                fileWriter.append(String.valueOf(number));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readDataToFile() {

    }
}
