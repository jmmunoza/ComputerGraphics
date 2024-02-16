package util.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {
    public static List<String> read(String absolutePath) throws FileNotFoundException {
        List<String> lines = new ArrayList<>();

        Scanner scanner = new Scanner(new File(absolutePath));
        while (scanner.hasNextLine()) lines.add(scanner.nextLine());
        scanner.close();

        return lines;
    }
}
