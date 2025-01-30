package learn.library.data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReader {
    private String filePath;

    public CSVReader(String filePath) {
        this.filePath = "expense_report.csv";
    }

    public ArrayList<String> readCSVFile() {
        ArrayList<String> records = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            while (line != null) {
                records.add(line);
                line = reader.readLine();
            }
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
        return records;
    }
}
